//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.54 build 2714.21485)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.MosSearch;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.admin.domain.impl.MosSearchImpl;
import ims.admin.vo.ReportTemplateVo;
import ims.admin.vo.ReportTemplateVoCollection;
import ims.admin.vo.UserEmailAccountVo;
import ims.admin.vo.domain.UserEmailAccountVoAssembler;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.UserEmailAccount;
import ims.core.admin.pas.domain.objects.PASEvent;
import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.documents.domain.objects.Document;
import ims.core.domain.ADT;
import ims.core.domain.Demographics;
import ims.core.domain.impl.ADTImpl;
import ims.core.domain.impl.DemographicsImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.DocumentVo;
import ims.core.vo.GP;
import ims.core.vo.GpShortVoCollection;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.MemberOfStaffLiteVoCollection;
import ims.core.vo.MemberOfStaffShortVoCollection;
import ims.core.vo.PasEventLiteVo;
import ims.core.vo.PasEventVo;
import ims.core.vo.Patient;
import ims.core.vo.PatientShort;
import ims.core.vo.domain.DocumentVoAssembler;
import ims.core.vo.domain.GpShortVoAssembler;
import ims.core.vo.domain.PasEventLiteVoAssembler;
import ims.core.vo.domain.PasEventVoAssembler;
import ims.core.vo.lookups.PasEventType;
import ims.correspondence.domain.CorrespondenceHeadersAdmin;
import ims.correspondence.domain.ProcessReport;
import ims.correspondence.domain.TemplateSelect;
import ims.correspondence.domain.base.impl.BaseCorrespondenceDetailImpl;
import ims.correspondence.domain.objects.CorrespondenceDetails;
import ims.correspondence.vo.CorrespondenceDetailsRefVo;
import ims.correspondence.vo.CorrespondenceDetailsVo;
import ims.correspondence.vo.CorrespondenceStatusHistoryVoCollection;
import ims.correspondence.vo.DocReportVo;
import ims.correspondence.vo.TemplateCategoryVo;
import ims.correspondence.vo.TemplateCategoryVoCollection;
import ims.correspondence.vo.domain.CorrespondenceDetailsVoAssembler;
import ims.correspondence.vo.domain.CorrespondenceStatusHistoryVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.domain.lookups.LookupService;
import ims.dto.Result;
import ims.dto.client.Inpatientlist;
import ims.dto.client.Outpatientlist;
import ims.dto.client.Patientcontacts;
import ims.dto.client.Patientcontacts.PatientcontactsRecord;
import ims.framework.FormName;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;
import ims.reports.ReportEngine;
import ims.vo.LookupInstVo;
import ims.vo.ValueObject;

public class CorrespondenceDetailImpl extends BaseCorrespondenceDetailImpl
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Class getLookupServiceClass()
	{
		return ims.domain.lookups.impl.LookupServiceImpl.class;
	}

	/* (non-Javadoc)
	 * @see ims.correspondence.domain.GenerateDischargeLetter#saveDocumentDetails(ims.correspondence.vo.CorrespondenceDetailsVo)
	 */
	public CorrespondenceDetailsVo saveCorrespondenceDetails(CorrespondenceDetailsVo voDocDetail, LookupInstVo pasEventType) throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException 
	{

		if (!voDocDetail.isValidated())
		{
			throw new DomainRuntimeException("CorrespondenceDetailsVo not validated.");
		}

		DomainFactory factory = getDomainFactory();
		CorrespondenceDetails domDocDetails = null;
		
		domDocDetails = CorrespondenceDetailsVoAssembler.extractCorrespondenceDetails(factory,voDocDetail);
		
		try
		{
			factory.save(domDocDetails);
		}
		catch (UnqViolationUncheckedException e) 
		{
			throw new UniqueKeyViolationException("A Correspondence details already exists for the chosen PASEvent. Duplicates not allowed.", e);
		}
		
		saveCurrentDocStatus(voDocDetail,pasEventType);
		
		return CorrespondenceDetailsVoAssembler.create(domDocDetails);
		
	}
	
	private void saveCurrentDocStatus(CorrespondenceDetailsVo voDocDetail,LookupInstVo pasEventType) throws StaleObjectException
	{
		savePasEventDocumentStatus(voDocDetail);
		
		if (ConfigFlag.UI.DEMOGRAPHICS_TYPE.equals("IRISH"))
			savePasDocumentStatus(voDocDetail,pasEventType);			
	}
	
	private void savePasEventDocumentStatus(CorrespondenceDetailsVo voDocDetail) throws StaleObjectException
	{
		if (voDocDetail != null && voDocDetail.getCurrentStatusIsNotNull())
		{
			DomainFactory factory = getDomainFactory();
			PASEvent domPas = (PASEvent) factory.getDomainObject(PASEvent.class, voDocDetail.getPasEvent().getID_PASEvent());
			PasEventVo voPasEvent = PasEventVoAssembler.create(domPas);
						
			voPasEvent.setCspDocumentStatus(voDocDetail.getCurrentStatus());
			
			domPas = PasEventVoAssembler.extractPASEvent(factory,voPasEvent);
			
			factory.save(domPas);						
		}		
	}
	
	private String savePasDocumentStatus(CorrespondenceDetailsVo voDocDetail,LookupInstVo pasEventType) 
	{
		/*
		if (voDocDetail != null && voDocDetail.getCurrentStatusIsNotNull())
		{
			DomainFactory factory = getDomainFactory();
			PASEvent domPas = (PASEvent) factory.getDomainObject(PASEvent.class, voDocDetail.getPasEvent().getID_PASEvent());
			PasEventLiteVo voPasEvent = PasEventLiteVoAssembler.create(domPas);
			Result dtoResult;
			String strStatus = "";
			
			if (pasEventType != null)
			{
				if (pasEventType.equals(PasEventType.INPATIENT))
				{
					Inpatientlist inpat = (Inpatientlist)getDTOInstance(Inpatientlist.class);
					inpat.Filter.clear();
		
					strStatus = "" + voDocDetail.getCurrentStatus().getId();
		
					// Update impatient list
					inpat.Filter.Contactno = voPasEvent.getPasEventId();
					dtoResult = inpat.get();
					if (null  != dtoResult)
						return new String(dtoResult.toString());
					
					inpat.DataCollection.get(0).Documentstatus = strStatus;
					dtoResult = inpat.update();
					if (null != dtoResult)
						return new String(dtoResult.toString());
				}
				else if (pasEventType.equals(PasEventType.OUTPATIENT))
				{
					Outpatientlist outpat = (Outpatientlist)getDTOInstance(Outpatientlist.class);
					outpat.Filter.clear();
		
					strStatus = "" + voDocDetail.getCurrentStatus().getId();
					
					// Update outpatient list
					outpat.Filter.Contactno = voPasEvent.getPasEventId();					
					dtoResult = outpat.get();
					if (null  != dtoResult)
						return new String(dtoResult.toString());
					
					outpat.DataCollection.get(0).Documentstatus = strStatus;					
					
					dtoResult = outpat.update();
					if (null != dtoResult)
						return new String(dtoResult.toString());				
				}
			}
			else
				return ("No PAS event type found");
			
			Patientcontacts patientContacts = (Patientcontacts)getDTOInstance(Patientcontacts.class);
			patientContacts.Filter.clear();			
						
			PatientcontactsRecord patientContactsRecord = patientContacts.new PatientcontactsRecord();
			patientContactsRecord.Contactno = voPasEvent.getPasEventId();
			patientContactsRecord.Documentstatus = strStatus;
			
			patientContacts.Filter.Contactno = voPasEvent.getPasEventId();
			dtoResult = patientContacts.get();
			
			if (null != dtoResult)
				return new String (dtoResult.toString());

			patientContacts.DataCollection.get(0).Documentstatus = strStatus;
			dtoResult = patientContacts.update();
			if (null != dtoResult)
				return new String(dtoResult.toString());
									
		}
		*/
		return new String();		
	}
	
	/* (non-Javadoc)
	 * @see ims.correspondence.domain.GenerateDischargeLetter#getReportAndTemplate(java.lang.Integer, java.lang.Integer)
	 */
	public String[] getReportAndTemplate(Integer nReportId, Integer nTemplateId) throws ims.domain.exceptions.DomainInterfaceException
	{
		ProcessReport impl = (ProcessReport)getDomainImpl(ProcessReportImpl.class);
		return impl.getReportAndTemplate(nReportId,nTemplateId);
	}
	
	/* (non-Javadoc)
	 * @see ims.correspondence.domain.GenerateDischargeLetter#getReport(java.lang.Integer)
	 */
	public DocReportVo getReport(Integer nReportQueryId) 
	{
		ProcessReport impl = (ProcessReport)getDomainImpl(ProcessReportImpl.class);
		return impl.getReport(nReportQueryId);
	}

	/* (non-Javadoc)
	 * @see ims.correspondence.domain.GenerateDischargeLetter#listTemplateDischargeCategories(ims.admin.vo.ReportTemplateVo)
	 */
	public TemplateCategoryVo listTemplateDischargeCategories(ReportTemplateVo templateFilterVo) 
	{
		CorrespondenceHeadersAdmin impl = (CorrespondenceHeadersAdmin)getDomainImpl(CorrespondenceHeadersAdminImpl.class);
		return impl.getTemplateCategories(templateFilterVo);
		
		
	}
	
	/* (non-Javadoc)
	 * @see ims.correspondence.domain.GenerateDischargeLetter#getPatient(ims.core.vo.PatientShort)
	 */
	public ims.core.vo.Patient getPatient(PatientShort voPatient) throws ims.domain.exceptions.StaleObjectException
	{
		Demographics implDemographics = (Demographics)getDomainImpl(DemographicsImpl.class);
		return implDemographics.getPatient(voPatient);
	}

	public DocumentVo getDocument(DocumentVo filter)
	{
		ProcessReport impl = (ProcessReport) getDomainImpl(ProcessReportImpl.class);
		return impl.getDocument(filter);
	}

	public GpShortVoCollection listReferralGps(GP voGpFilter) 
	{
		DomainFactory factory = getDomainFactory();
		String andStr = " ";
		StringBuffer clause = new StringBuffer();
 
		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		if (voGpFilter.getNameIsNotNull())
		{
			if (voGpFilter.getName().getForenameIsNotNull())
			{
				clause.append(" gp.name.upperForename like :forename");
				names.add("forename");
				values.add("%" + voGpFilter.getName().getForename().toUpperCase() + "%");		
				andStr = " and ";
			}
	
			if (voGpFilter.getName().getSurnameIsNotNull())
			{
				clause.append(andStr + " gp.name.upperSurname like :surname");
				names.add("surname");
				values.add("%" + voGpFilter.getName().getSurname().toUpperCase() + "%");		
				andStr = " and ";
			}
		}
		
		if (voGpFilter.getPracticesIsNotNull())
 		{
	  		if (voGpFilter.getPractices() != null)
			{
				if (voGpFilter.getPractices().get(0).getPractice().getAddress().getLine1() != null && voGpFilter.getPractices().get(0).getPractice().getAddress().getLine1().length() > 0)
				{
					clause.append(andStr + " gp.id = Pract.gp.id and (upper(Pract.practice.address.line1) like :partialAddress ");
					clause.append(" or upper(Pract.practice.address.line2) like :partialAddress");
					clause.append(" or upper(Pract.practice.address.line3) like :partialAddress");
					clause.append(" or upper(Pract.practice.address.line4) like :partialAddress");
					clause.append(" or upper(Pract.practice.address.line5) like :partialAddress )");
					//clause.append(" gp.id = Pract.gp.id and Pract.practice.address.line1 like :partialAddress ");

					names.add("partialAddress");
					values.add("%" + voGpFilter.getPractices().get(0).getPractice().getAddress().getLine1().toUpperCase() + "%");
					andStr = " and ";
				}
			}
        }
 
		String hql = "select distinct gp from Gp gp, GpToPractice Pract where ";
		
		hql += clause.toString();
		List gps = factory.find(hql,names,values);
		

		return GpShortVoAssembler.createGpShortVoCollectionFromGp(gps).sort();
	}
	
	
	public PasEventVo getPasEvent(PASEventRefVo pasEventRefVo) 
	{
		if (pasEventRefVo == null)
			throw new CodingRuntimeException("Mandatory Argument - PAS Event Required");
		
		ADT impl = (ADT)getDomainImpl(ADTImpl.class);
		return impl.getPasEvent(pasEventRefVo);
	}
	
	public CorrespondenceDetailsVo getCorrespondenceDetails(CorrespondenceDetailsRefVo voCorrespDetRefVo) 
	{
		if (voCorrespDetRefVo == null)
			throw new CodingRuntimeException("Mandatory Argument - Correspondence Details Required");
		
		DomainFactory factory = getDomainFactory();
		CorrespondenceDetails domCspDet = (CorrespondenceDetails) factory.getDomainObject(CorrespondenceDetails.class, voCorrespDetRefVo.getID_CorrespondenceDetails());
		return CorrespondenceDetailsVoAssembler.create(domCspDet);		
	}
	
	public CorrespondenceDetailsVo getCorrespondenceDetailsByPasEvent(PASEventRefVo voPasEventRef) 
	{
		if (voPasEventRef == null)
			throw new CodingRuntimeException("Mandatory Argument - PAS Event Required");
		DomainFactory factory = getDomainFactory();
		CorrespondenceDetails domCspDet = CorrespondenceDetails.getCorrespondenceDetailsFromPasEvent(factory, voPasEventRef.getID_PASEvent());
		return CorrespondenceDetailsVoAssembler.create(domCspDet);
	}
	
	public CorrespondenceStatusHistoryVoCollection getCorrespondenceStatusHistory(CorrespondenceDetailsRefVo voCorrespDetRef) 
	{
		if (voCorrespDetRef == null)
			throw new CodingRuntimeException("Mandatory Argument - Correspondence Details Required");
		DomainFactory factory = getDomainFactory();
		CorrespondenceDetails domCspDet = (CorrespondenceDetails) factory.getDomainObject(CorrespondenceDetails.class, voCorrespDetRef.getID_CorrespondenceDetails());
		return CorrespondenceStatusHistoryVoAssembler.createCorrespondenceStatusHistoryVoCollectionFromCorrespondenceStatusHistory(domCspDet.getCspStatusHistory());
	}

	public Patient getPatientLocal(PatientRefVo patientRefVo) 
	{
		Demographics implDemographics = (Demographics)getDomainImpl(DemographicsImpl.class);
		return implDemographics.getPatient(patientRefVo);
	}

	public DocumentVo getCurrentDocument(CorrespondenceDetailsRefVo voRefCorrecpondenceDetail) 
	{
		if (voRefCorrecpondenceDetail == null)
			throw new CodingRuntimeException("Mandatory Argument - Correspondence Details Required");
		
		CorrespondenceDetailsVo voCorrDet = getCorrespondenceDetails(voRefCorrecpondenceDetail);
		
		return voCorrDet.getCurrentDocument();
	}

	public ReportTemplateVoCollection listTemplates(Boolean activeOnly, Integer voMedicId, Integer voLocationId, Integer voServiceId) 
	{
		TemplateSelect implTemplateSelect = (TemplateSelect)getDomainImpl(TemplateSelectImpl.class);
		return implTemplateSelect.listTemplates(activeOnly,voMedicId,voLocationId,voServiceId);
	}

	public MedicLiteVoCollection listSignatories(String medicName) 
	{
		HcpAdmin impl = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return impl.listActiveMedics(medicName);
	}
 
	public UserEmailAccountVo getEmailAppUser(Integer appUserId) 
	{
		DomainFactory factory = getDomainFactory();
		return UserEmailAccountVoAssembler.create((UserEmailAccount)factory.getDomainObject(UserEmailAccount.class, appUserId));		
	}

	
	public void saveDocument(DocumentVo document) throws DomainInterfaceException, StaleObjectException, ForeignKeyViolationException, UniqueKeyViolationException
	{
		DomainFactory factory = getDomainFactory();
	
		Document domDoc = DocumentVoAssembler.extractDocument(factory, document);
		
		factory.save(domDoc);
		
		
	}

	
	public MemberOfStaffLiteVoCollection getMos(String mosName)
	{
		MosSearch impl = (MosSearch)getDomainImpl(MosSearchImpl.class);
		
		 return impl.listActiveMosByName(mosName);
	}

	

	
}
