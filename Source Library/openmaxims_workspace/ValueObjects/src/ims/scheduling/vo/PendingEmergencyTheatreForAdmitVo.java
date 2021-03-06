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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.scheduling.vo;

/**
 * Linked to Scheduling.PendingEmergencyTheatre business object (ID: 1090100024).
 */
public class PendingEmergencyTheatreForAdmitVo extends ims.scheduling.vo.PendingEmergencyTheatreRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IPendingAdmissionDetails
{
	private static final long serialVersionUID = 1L;

	public PendingEmergencyTheatreForAdmitVo()
	{
	}
	public PendingEmergencyTheatreForAdmitVo(Integer id, int version)
	{
		super(id, version);
	}
	public PendingEmergencyTheatreForAdmitVo(ims.scheduling.vo.beans.PendingEmergencyTheatreForAdmitVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.referral = bean.getReferral() == null ? null : bean.getReferral().buildVo();
		this.currentstatus = bean.getCurrentStatus() == null ? null : ims.scheduling.vo.lookups.PendingEmergencyTheatreStatus.buildLookup(bean.getCurrentStatus());
		this.expecteddatetime = bean.getExpectedDateTime() == null ? null : bean.getExpectedDateTime().buildDateTime();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.admissiondetail = bean.getAdmissionDetail() == null ? null : new ims.core.admin.pas.vo.AdmissionDetailRefVo(new Integer(bean.getAdmissionDetail().getId()), bean.getAdmissionDetail().getVersion());
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.beans.PendingEmergencyTheatreForAdmitVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.referral = bean.getReferral() == null ? null : bean.getReferral().buildVo(map);
		this.currentstatus = bean.getCurrentStatus() == null ? null : ims.scheduling.vo.lookups.PendingEmergencyTheatreStatus.buildLookup(bean.getCurrentStatus());
		this.expecteddatetime = bean.getExpectedDateTime() == null ? null : bean.getExpectedDateTime().buildDateTime();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.admissiondetail = bean.getAdmissionDetail() == null ? null : new ims.core.admin.pas.vo.AdmissionDetailRefVo(new Integer(bean.getAdmissionDetail().getId()), bean.getAdmissionDetail().getVersion());
		this.responsiblehcp = bean.getResponsibleHCP() == null ? null : bean.getResponsibleHCP().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.beans.PendingEmergencyTheatreForAdmitVoBean bean = null;
		if(map != null)
			bean = (ims.scheduling.vo.beans.PendingEmergencyTheatreForAdmitVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.scheduling.vo.beans.PendingEmergencyTheatreForAdmitVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("REFERRAL"))
			return getReferral();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("EXPECTEDDATETIME"))
			return getExpectedDateTime();
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("ADMISSIONDETAIL"))
			return getAdmissionDetail();
		if(fieldName.equals("RESPONSIBLEHCP"))
			return getResponsibleHCP();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientLite_IdentifiersVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientLite_IdentifiersVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getReferralIsNotNull()
	{
		return this.referral != null;
	}
	public ims.RefMan.vo.CatsReferralForClinicListVo getReferral()
	{
		return this.referral;
	}
	public void setReferral(ims.RefMan.vo.CatsReferralForClinicListVo value)
	{
		this.isValidated = false;
		this.referral = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.scheduling.vo.lookups.PendingEmergencyTheatreStatus getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.scheduling.vo.lookups.PendingEmergencyTheatreStatus value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getExpectedDateTimeIsNotNull()
	{
		return this.expecteddatetime != null;
	}
	public ims.framework.utils.DateTime getExpectedDateTime()
	{
		return this.expecteddatetime;
	}
	public void setExpectedDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.expecteddatetime = value;
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.core.vo.ServiceLiteVo getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.ServiceLiteVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getAdmissionDetailIsNotNull()
	{
		return this.admissiondetail != null;
	}
	public ims.core.admin.pas.vo.AdmissionDetailRefVo getAdmissionDetail()
	{
		return this.admissiondetail;
	}
	public void setAdmissionDetail(ims.core.admin.pas.vo.AdmissionDetailRefVo value)
	{
		this.isValidated = false;
		this.admissiondetail = value;
	}
	public boolean getResponsibleHCPIsNotNull()
	{
		return this.responsiblehcp != null;
	}
	public ims.core.vo.HcpLiteVo getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.responsiblehcp = value;
	}
	/**
	* IPendingAdmissionDetails implementation
	*/
	public String getPatientSurname()
	{
		if (this.patient != null)
			return this.patient.getPatientSurname();
	
		return null;
	}
	
	public String getPatientForename()
	{
		if (this.patient != null)
			return this.patient.getPatientForename();
	
		return null;
	}
	
	public ims.core.vo.PatientId getPatientDisplayIdentifier()
	{
		if (this.patient != null)
			return this.patient.getPatientDisplayIdentifier();
	
		return null;
	}
	
	public ims.core.vo.lookups.Sex getPatientSex()
	{
		if (this.patient != null)
			return this.patient.getPatientSex();
	
		return null;
	}
	
	public Integer getPatientAge()
	{
		if (this.patient != null)
			return this.patient.getPatientAge();
	
		return null;
	}
	
	public ims.framework.utils.PartialDate getPatientDoB()
	{
		if (this.patient != null)
			return this.patient.getPatientDoB();
	
		return null;
	}
	
	public String getLengthOfStay()
	{
		return null;
	}
	
	public ims.framework.utils.DateTime getTCIDateTime()
	{
		return null;
	}
	
	public Boolean hasTCIComments()
	{
		return null;
	}
	
	public ims.framework.utils.Time getWardAttendanceAppointmentTime()
	{
		return null;
	}
	
	public ims.core.vo.ServiceLiteVo getPendingAdmissionService()
	{
		return this.service;
	}
	
	public ims.core.vo.lookups.Specialty getPendingAdmissionSpecialty()
	{
		return null;
	}
	
	public ims.core.vo.MemberOfStaffLiteVo getPendingAdmissionConsultant()
	{
		if (this.responsiblehcp != null)
			return this.responsiblehcp.getMos();
		return null;
	}
	public ims.core.vo.lookups.MethodOfAdmission getPendingAdmissionMethodOfAdmission()
	{
		return null;
	}
	
	public ims.core.vo.lookups.PatientStatus getPendingAdmissionPatientCategory()
	{
		if (this.referral != null)
			return this.referral.getPatientCategory();
		return null;
	}
	
	public Integer getPendingAdmissionAnticipatedStay()
	{
		return null;
	}
	
	public ims.core.vo.lookups.SourceOfEmergencyReferral getPendingAdmissionSourceOfEmergencyReferral()
	{
		return null;
	}
	
	public ims.core.vo.lookups.SourceOfReferral getPendingAdmissionSourceOfReferral()
	{
		return null;
	}
	
	public String getPendingAdmissionReasonForAdmission()
	{
		return null;
	}
	
	public ims.core.vo.MedicLiteVo getPendingAdmissionReferringConsultant()
	{
		return null;
	}
	
	public Boolean getPendingAdmissionSelfAdmit()
	{
		return null;
	}
	
	public ims.framework.utils.Date getPatientDod()
	{
		return this.patient.getDod();
	}
	
	public ims.core.patient.vo.PatientRefVo getPatientAssociatedPatient()
	{
		return this.patient.getAssociatedPatient();
	}
	
	public ims.framework.utils.Time getPatientTimeOfDeath()
	{
		return this.patient.getTimeOfDeath();
	}
	
	public String getPatientAgeText()
	{
		return this.patient.calculateAgeText();
	}
	
	public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
	{
		return (ims.RefMan.vo.CatsReferralRefVo)this.referral;
	}
	
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.referral == null)
			listOfErrors.add("Referral is mandatory");
		if(this.currentstatus == null)
			listOfErrors.add("CurrentStatus is mandatory");
		if(this.service == null)
			listOfErrors.add("Service is mandatory");
		if(this.responsiblehcp == null)
			listOfErrors.add("ResponsibleHCP is mandatory");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PendingEmergencyTheatreForAdmitVo clone = new PendingEmergencyTheatreForAdmitVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientLite_IdentifiersVo)this.patient.clone();
		if(this.referral == null)
			clone.referral = null;
		else
			clone.referral = (ims.RefMan.vo.CatsReferralForClinicListVo)this.referral.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.scheduling.vo.lookups.PendingEmergencyTheatreStatus)this.currentstatus.clone();
		if(this.expecteddatetime == null)
			clone.expecteddatetime = null;
		else
			clone.expecteddatetime = (ims.framework.utils.DateTime)this.expecteddatetime.clone();
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.core.vo.ServiceLiteVo)this.service.clone();
		clone.admissiondetail = this.admissiondetail;
		if(this.responsiblehcp == null)
			clone.responsiblehcp = null;
		else
			clone.responsiblehcp = (ims.core.vo.HcpLiteVo)this.responsiblehcp.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(PendingEmergencyTheatreForAdmitVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PendingEmergencyTheatreForAdmitVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PendingEmergencyTheatreForAdmitVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PendingEmergencyTheatreForAdmitVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.referral != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.expecteddatetime != null)
			count++;
		if(this.service != null)
			count++;
		if(this.admissiondetail != null)
			count++;
		if(this.responsiblehcp != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.vo.PatientLite_IdentifiersVo patient;
	protected ims.RefMan.vo.CatsReferralForClinicListVo referral;
	protected ims.scheduling.vo.lookups.PendingEmergencyTheatreStatus currentstatus;
	protected ims.framework.utils.DateTime expecteddatetime;
	protected ims.core.vo.ServiceLiteVo service;
	protected ims.core.admin.pas.vo.AdmissionDetailRefVo admissiondetail;
	protected ims.core.vo.HcpLiteVo responsiblehcp;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
