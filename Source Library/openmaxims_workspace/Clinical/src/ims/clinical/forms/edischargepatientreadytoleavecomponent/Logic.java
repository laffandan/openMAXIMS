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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.70 build 3420.15896)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.clinical.forms.edischargepatientreadytoleavecomponent;

import ims.clinical.forms.edischargepatientreadytoleavecomponent.GenForm.grdSummaryRow;
import ims.clinical.vo.DischargeDetailsVo;
import ims.clinical.vo.DischargeMedicationDetailsVo;
import ims.clinical.vo.DischargeReadyToLeaveVo;
import ims.clinical.vo.DischargeReportDetailVo;
import ims.clinical.vo.NurseEnabledInstructionsVo;
import ims.clinical.vo.RTLSummaryVo;
import ims.clinical.vo.lookups.DischargeLetterStatus;
import ims.clinical.vo.lookups.TTORequired;
import ims.clinicaladmin.vo.lookups.EDischargeHINT;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.FieldHelpVo;
import ims.core.vo.GPLiteWithCommChannelsVoCollection;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.PatientNoDiagInfoForCCVo;
import ims.core.vo.PatientShort;
import ims.core.vo.enums.AuthoringLabelType;
import ims.core.vo.enums.MosType;
import ims.core.vo.lookups.ChannelType;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.PatientDiagnosisStatus;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.FormName;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.interfaces.ILocation;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.framework.utils.PartialDate;
import ims.vo.interfaces.IMos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
	private String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
	private int COL_SUMMARY_PARAM_NAME = 0;
	private int COL_SUMMARY_PARAM_VALUE = 1;
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setisReadonly(false);
		form.setMode(FormMode.VIEW);
		initialise();
	}

	@Override
	protected void onFormModeChanged()
	{
		if (form.getMode().equals(FormMode.EDIT))
		{
			form.btnSave().setVisible(true);
			activatedeactivatecontrols(true);
			
			form.btnPrintDisch().setEnabled(false);
			form.btnPrintDisch().setVisible(false);
			form.imbPrintDisch().setEnabled(false);
			form.imbPrintDisch().setVisible(false);
			/*
			 * if (form.getLocalContext().getisReadonly())
			 * form.btnCompleted().setVisible(form.getMode().equals(FormMode.EDIT) ?
			 * false : false); else {
			 * form.btnCompleted().setVisible(form.getMode().equals(FormMode.EDIT) ?
			 * true : false);
			 * form.btnCompleted().setEnabled(form.getMode().equals(FormMode.EDIT) ?
			 * true : false); }
			 */
		}
		else if (form.getMode().equals(FormMode.VIEW))
		{
			form.btnEdit().setVisible(true);// form.getLocalContext().getisReadonly()
											// == false ? true : false);
			form.btnEdit().setEnabled(true);// form.getLocalContext().getisReadonly()
											// == false ? true : false);
		}
		
		form.lblMessage().setVisible(form.getLocalContext().getSelectedRecordIsNotNull()&& form.getLocalContext().getSelectedRecord().getDischargeDetailsIsNotNull() && !(DischargeLetterStatus.GENERATED.equals(form.getLocalContext().getSelectedRecord().getDischargeDetails().getDischargeLetterStatus()))); //WDEV-18845
		
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		editData();
		
	}

	private void editData() 
	{
		form.setMode(FormMode.EDIT);
		if (form.getLocalContext().getSelectedRecord() == null || (form.getLocalContext().getSelectedRecordIsNotNull() && form.getLocalContext().getSelectedRecord().getID_ReadyToLeave() == null))
		{
			form.ccAuthoring().initializeComponent();
			// WDEV-8363
			form.dtimDODisch().setValue(new DateTime(new Date()));
			addPatientWard();
		}

		form.getGlobalContext().Clinical.seteDischargeDisableTabs(true);
		form.fireCustomControlValueChanged();
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			open();
			form.fireCustomControlValueChanged();
		}
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		open();

		form.getGlobalContext().Clinical.seteDischargeDisableTabs(false);
		form.fireCustomControlValueChanged();
	}

	@Override
	protected void onBtnPrintDischClick() throws PresentationLogicException
	{
		buildReport();
		
		if (form.getMode().equals(FormMode.VIEW))
			editData();
		
		open();
		manageCheckBox(true, true);
	}

	private void manageCheckBox(boolean bShow, boolean bEnable) 
	{
		form.chkLetterGiven().setVisible(bShow);
		form.chkLetterGiven().setEnabled(bEnable);
		form.lblLetterGiven().setVisible(bShow);
	}

	private void addPatientWard()
	{
		PatientShort voPat = form.getGlobalContext().Core.getPatientShort();

		if (voPat.getWard() != null)
		{
			form.cmbDischWard().newRow(voPat.getWard(), voPat.getWard().getName());
			form.cmbDischWard().setValue(voPat.getWard());
		}
	}

	private void populateScreenFromData(DischargeReadyToLeaveVo voReady)
	{
		if (voReady == null)
			return;
		//--	
		form.txtNurseEnabledDischargeInstruction().setValue((voReady.getDischargeDetailsIsNotNull()&& voReady.getDischargeDetails().getNurseEnabledInstructionsIsNotNull())? voReady.getDischargeDetails().getNurseEnabledInstructions().getNurseEnabledInstructions() : null);
		//---
		form.txtNurseEnabledConfirmation().setValue(voReady.getNurseEnabledDischargeConfirmation());
		form.dtimDODisch().setValue(voReady.getCompletedOnIsNotNull() ? voReady.getCompletedOn() : null);
		form.ccAuthoring().setValue(voReady.getAuthoringInfoIsNotNull() ? voReady.getAuthoringInfo() : null);
		if (voReady.getHasPatientReceivedCopyOfDischargeIsNotNull())
		{
			form.chkLetterGiven().setValue(voReady.getHasPatientReceivedCopyOfDischarge());
			manageCheckBox(true, false);
		}

		//check if the gps have email and if letter status is IN_PROGRESS / GENERATED and HasPatientReceivedCopyOfDischarge == null
		checkIfCheckBoxShouldBeDisplayedAnyway(voReady);
		
		if (voReady.getDischargeDetailsIsNotNull())
		{
			DischargeDetailsVo voDisch = voReady.getDischargeDetails();

			form.ccDischCons().setValue(voDisch.getDischargingConsultantIsNotNull() ? voDisch.getDischargingConsultant() : null);
			form.cmbDischSpec().setValue(voDisch.getDischargingSpecialtyIsNotNull() ? voDisch.getDischargingSpecialty() : null);
			form.dtimDODisch().setValue(voDisch.getDateOfDischargeIsNotNull() ? voDisch.getDateOfDischarge() : null);
			form.cmbDischMethod().setValue(voDisch.getDischargeMethodIsNotNull() ? voDisch.getDischargeMethod() : null);
			form.cmbDischDest().setValue(voDisch.getDischargeDestinationIsNotNull() ? voDisch.getDischargeDestination() : null);
			form.cmbDischWard().setValue(voDisch.getDischargingWardIsNotNull() ? voDisch.getDischargingWard() : null);
			if (voDisch.getDischargingWardIsNotNull() && form.cmbDischWard().getValue() == null)
			{
				form.cmbDischWard().newRow(voDisch.getDischargingWard(), voDisch.getDischargingWard().getName());
				form.cmbDischWard().setValue(voDisch.getDischargingWard());
			}
		}
		
	}
	private void checkIfCheckBoxShouldBeDisplayedAnyway(DischargeReadyToLeaveVo voReady) 
	{
		DischargeReportDetailVo voDischReport = domain.getDischargeReportDetailsForCareContext(form.getGlobalContext().Core.getCurrentCareContext());

		form.getLocalContext().setCurrentDischargeReportDetailVo(voDischReport);
		
		boolean hasEmail = false;
		if (voDischReport != null && voDischReport.getGpRecipientsIsNotNull())
		{					
			for (int j = 0; j < voDischReport.getGpRecipients().size(); j++) 
			{
				GPLiteWithCommChannelsVoCollection gps = voDischReport.getGpRecipients();
				if (gps != null &&
						gps.size() > 0)
				{
					for (int k = 0; k < gps.size() ; k++) 
					{
						if (gps.get(k).getCommChannelsIsNotNull() &&
								gps.get(k).getCommChannels().size() > 0)
						{
							for (int l = 0; l < gps.get(k).getCommChannels().size(); l++) 
							{
								if (gps.get(k).getCommChannels().get(l).getChannelTypeIsNotNull() &&
										gps.get(k).getCommChannels().get(l).getChannelType().equals(ChannelType.EMAIL))
								{
									hasEmail = true;
								}
							}											
						}
					}								
				}
			}
		}
		
		DischargeDetailsVo volocalDD = domain.getDischargeDetails(form.getGlobalContext().Core.getCurrentCareContext());
		form.getLocalContext().setCurrentDischargeDetailsVo(volocalDD);

		if ( !hasEmail
			&& voDischReport != null
			&& volocalDD != null
			&& volocalDD.getDischargeLetterStatusIsNotNull()
			&& volocalDD.getDischargeLetterStatus().equals(DischargeLetterStatus.GENERATED)
			&& (voReady.getHasPatientReceivedCopyOfDischarge() == null
					|| (voReady.getHasPatientReceivedCopyOfDischargeIsNotNull()	&&  ! voReady.getHasPatientReceivedCopyOfDischarge()) ) )
		{
			form.chkLetterGiven().setVisible(true);
			form.lblLetterGiven().setVisible(true);
			
			if (form.getMode().equals(FormMode.EDIT))
				form.chkLetterGiven().setEnabled(true);
		}
		
	}

	private void clearInstanceControls()
	{
		form.txtNurseEnabledDischargeInstruction().setValue(null);
		form.txtNurseEnabledConfirmation().setValue(null);
		form.dtimDODisch().setValue(null);
		form.cmbDischMethod().setValue(null);
		form.cmbDischDest().setValue(null);
		form.ccDischCons().setValue(null);
		form.cmbDischSpec().setValue(null);
		form.cmbDischWard().setValue(null);
		form.ccAuthoring().setValue(null);
		form.chkLetterGiven().setValue(false);
		form.dynGrdEdischSummary().getRows().clear(); //WDEV-18916
		
	}
	private void populateRTLSummaryControls(RTLSummaryVo readyToLeaveSummary)
	{
		if (readyToLeaveSummary == null)
		{
			initializeSummaryGrid();
			return;
		}
		populateSummaryGrid(readyToLeaveSummary);//WDEV-18845
		
	}
	
	//WDEV-18845
	private void initializeSummaryGrid()
	{
		form.grdSummary().getRows().clear();

		grdSummaryRow row1 = form.grdSummary().getRows().newRow();
		row1.setColumn1("Diagnoses");
		
		grdSummaryRow row2 = form.grdSummary().getRows().newRow();
		row2.setColumn1("Complications");
		
		grdSummaryRow row3 = form.grdSummary().getRows().newRow();
		row3.setColumn1("Co-Morbidities");
	
	}	

	//WDEV-18916
	private void populateEDischSummaryGridFromRTLData(RTLSummaryVo readyToLeaveSummary, DischargeMedicationDetailsVo voMeds)
	{
		
		DynamicGridRow medicationRow = form.dynGrdEdischSummary().getRows().newRow();
		medicationRow.setSelectable(Boolean.FALSE);
		medicationRow.setReadOnly(Boolean.TRUE);
		DynamicGridCell paramNameCell = medicationRow.getCells().newCell(getColumn(COL_SUMMARY_PARAM_NAME), DynamicCellType.HTMLVIEW);
		paramNameCell.setValue("Medication");
		
			
		DynamicGridRow signOffRow = form.dynGrdEdischSummary().getRows().newRow();
		signOffRow.setSelectable(Boolean.FALSE);
		signOffRow.setReadOnly(Boolean.TRUE);
		paramNameCell = signOffRow.getCells().newCell(getColumn(COL_SUMMARY_PARAM_NAME), DynamicCellType.HTMLVIEW);
		paramNameCell.setValue("Signed Off by Clinician");
				
		DynamicGridRow readyToLeaveRow = form.dynGrdEdischSummary().getRows().newRow();
		readyToLeaveRow.setSelectable(Boolean.FALSE);
		readyToLeaveRow.setReadOnly(Boolean.TRUE);
		paramNameCell = readyToLeaveRow.getCells().newCell(getColumn(COL_SUMMARY_PARAM_NAME), DynamicCellType.HTMLVIEW);
		paramNameCell.setValue("'Ready to Leave' Completed"); 
				
		String medicationDisplayInfo = getMedicationDisplayText(voMeds);
		DynamicGridCell paramValueCell = medicationRow.getCells().newCell(getColumn(COL_SUMMARY_PARAM_VALUE), DynamicCellType.HTMLVIEW);
		paramValueCell.setValue(medicationDisplayInfo != null ?  "&nbsp;" + medicationDisplayInfo : "");
		medicationRow.setBackColor(form.getLocalContext().getSummaryMedicationParamColour());
						
		if (readyToLeaveSummary != null)
		{	
			boolean wasSignedOff =  readyToLeaveSummary.getWasPreviewSignedOff() != null && readyToLeaveSummary.getWasPreviewSignedOff();
			paramValueCell = signOffRow.getCells().newCell(getColumn(COL_SUMMARY_PARAM_VALUE), DynamicCellType.HTMLVIEW);
			paramValueCell.setValue(wasSignedOff ? "&nbsp;Signed Off" : "");
			if (wasSignedOff)
				signOffRow.setBackColor(Color.LightGreen);

			boolean wasRTLComplete = readyToLeaveSummary.getWasRTLCompleted() != null && readyToLeaveSummary.getWasRTLCompleted();
			paramValueCell = readyToLeaveRow.getCells().newCell(getColumn(COL_SUMMARY_PARAM_VALUE), DynamicCellType.HTMLVIEW);
			paramValueCell.setValue(wasRTLComplete ? "&nbsp;Completed" : "");
			if (wasRTLComplete)
				readyToLeaveRow.setBackColor(Color.LightGreen);	
		}		
	}

	//WDEV-18916
	private String getMedicationDisplayText(DischargeMedicationDetailsVo voMeds)
	{
		if (voMeds == null || voMeds.getTTARequired() == null)
		{	
			form.getLocalContext().setSummaryMedicationParamColour(Color.Default); //WDEV-19000
			return null;
		}	
		
		if (TTORequired.REQUIRED.equals(voMeds.getTTARequired()))
		{
			if (Boolean.TRUE.equals(voMeds.getTTAReceived())) //WDEV-19271
			{	
				form.getLocalContext().setSummaryMedicationParamColour(Color.LightGreen);
				return "Required and Received" ;
			}	
			form.getLocalContext().setSummaryMedicationParamColour(Color.DarkOrange);
			return "Required and NOT Received";
		
		}
		form.getLocalContext().setSummaryMedicationParamColour(Color.LightGreen);
		return voMeds.getTTARequired().getText(); 
		
		
	}

	//WDEV-18845
	private void populateSummaryGrid(RTLSummaryVo readyToLeaveSummary)
	{
		form.grdSummary().getRows().clear();
		
		form.getLocalContext().setCurrentDischargeDetailsVo(domain.getDischargeDetails(form.getGlobalContext().Core.getCurrentCareContext()));
		
		grdSummaryRow row1 = form.grdSummary().getRows().newRow();
		boolean diagRecorded = readyToLeaveSummary!=null && Boolean.TRUE.equals(readyToLeaveSummary.getWereDiagnosisDetailsEntered());
		
		PatientNoDiagInfoForCCVo patientNoDiagInfo = domain.getPatientNoDiagInfoForCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		boolean diagNoKnownRecorded;
		
		if (patientNoDiagInfo != null)
		{
			diagNoKnownRecorded = PatientDiagnosisStatus.NOKNOWNDIAGNOSISFOREPISODE.equals(patientNoDiagInfo.getDiagnosisStatus());
		}
		else
			diagNoKnownRecorded = form.getLocalContext().getCurrentDischargeDetailsVo() != null && form.getLocalContext().getCurrentDischargeDetailsVo().getHasNoDiagnosis() != null ? form.getLocalContext().getCurrentDischargeDetailsVo().getHasNoDiagnosis() : false;
		
		row1.setColumn1("Diagnoses");
		row1.setColumn2(diagNoKnownRecorded ? "No diagnosis to record"  : (diagRecorded ? "Recorded" : "" ));//WDEV-20282 //WDEV-20446
		if (diagRecorded || diagNoKnownRecorded) //WDEV-20446 //WDEV-20551
			row1.setBackColor(Color.LightGreen);
		
		grdSummaryRow row2 = form.grdSummary().getRows().newRow();
		boolean compRecorded =readyToLeaveSummary!=null && Boolean.TRUE.equals(readyToLeaveSummary.getWereComplicationsEntered());
		boolean compNoKnownRecorded = form.getLocalContext().getCurrentDischargeDetailsVoIsNotNull() && Boolean.TRUE.equals(form.getLocalContext().getCurrentDischargeDetailsVo().getHasNoComplications());	
		row2.setColumn1("Complications");
		row2.setColumn2(compNoKnownRecorded ? "No complications for this episode" : (compRecorded? "Recorded" :  "" ));//WDEV-20282 // WDEV-20446 //WDEV-20551
		if (compRecorded || compNoKnownRecorded) //WDEV-20446 //WDEV-20551
			row2.setBackColor(Color.LightGreen);
		
		grdSummaryRow row3 = form.grdSummary().getRows().newRow();
		boolean comorbRecorded =readyToLeaveSummary!=null &&  Boolean.TRUE.equals(readyToLeaveSummary.getWereCoMorbiditiesEntered());
		boolean comorbNoKnownRecorded =form.getLocalContext().getCurrentDischargeDetailsVoIsNotNull() &&  Boolean.TRUE.equals(form.getLocalContext().getCurrentDischargeDetailsVo().getHasNoComorbidities());
		row3.setColumn1("Co-Morbidities");
		row3.setColumn2(comorbNoKnownRecorded ? "No relevant co-morbidities for this episode" :  (comorbRecorded? "Recorded" : "" )); //WDEV-20282
		if (comorbRecorded || comorbNoKnownRecorded) //WDEV-20446 //WDEV-20551
			row3.setBackColor(Color.LightGreen);
	}

	private DischargeReadyToLeaveVo populateDataFromScreen()
	{
		DischargeReadyToLeaveVo voReady = null;
		if (form.getLocalContext().getSelectedRecordIsNotNull())
			voReady = form.getLocalContext().getSelectedRecord();
		else
			voReady = new DischargeReadyToLeaveVo();

		if (voReady.getCareContext() == null)
			voReady.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());

		voReady.setNurseEnabledDischargeConfirmation(form.txtNurseEnabledConfirmation().getValue());
		// voReady.setNurseEnabledInstructions(form.txtNurseEnabledDischargeInstruction().getValue());
		voReady.setAuthoringInfo(form.ccAuthoring().getValue());
		
		if (form.chkLetterGiven().isVisible())
			voReady.setHasPatientReceivedCopyOfDischarge(form.chkLetterGiven().getValue());

		DischargeDetailsVo voDisch = null;
		if (form.getLocalContext().getSelectedRecordIsNotNull() && voReady.getDischargeDetailsIsNotNull())
			voDisch = form.getLocalContext().getSelectedRecord().getDischargeDetails();
		else
			voDisch = new DischargeDetailsVo();

		if (voDisch != null)
		{
			IMos hcp = form.ccDischCons().getValue();
			if (hcp != null)
			{
				HcpLiteVo completingHcp = domain.getHcp((HcpRefVo) hcp);
				voDisch.setDischargingConsultant(completingHcp);
			}
			voDisch.setDischargingSpecialty(form.cmbDischSpec().getValue());

			if (voDisch.getCareContext() == null)
				voDisch.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());

			voDisch.setDateOfDischarge(form.dtimDODisch().getValue());
			voDisch.setDischargeMethod(form.cmbDischMethod().getValue());
			voDisch.setDischargeDestination(form.cmbDischDest().getValue());
			voDisch.setDischargingWard(form.cmbDischWard().getValue());
			
			//-----------
			if(voDisch.getNurseEnabledInstructions() == null)
			{
				NurseEnabledInstructionsVo voN = new NurseEnabledInstructionsVo();
				voN.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
				voDisch.setNurseEnabledInstructions(voN);
			}
				
			voDisch.getNurseEnabledInstructions().setNurseEnabledInstructions(form.txtNurseEnabledDischargeInstruction().getValue());
			//--------------
			
//			 TODO		voDisch.setNurseEnabledInstructions(form.txtNurseEnabledDischargeInstruction().getValue());
			
			
			voReady.setDischargeDetails(voDisch);
		}

		return voReady;
	}
	
	private RTLSummaryVo populateRTLSummary(CareContextShortVo careContext)
	{
		if (careContext == null)
			return null;
		
		RTLSummaryVo rTLSummary = form.getLocalContext().getEdischargeRTLSummary();
		if (rTLSummary == null)
		{
			rTLSummary = new RTLSummaryVo();
		}
		rTLSummary.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		rTLSummary.setWasPrintPressed(Boolean.TRUE.equals(form.chkLetterGiven().getValue()));
		rTLSummary.setWasRTLCompleted(form.getLocalContext().getSelectedRecord() != null && form.dtimDODisch().getValue() != null);

		return rTLSummary;
	}
	private boolean save()
	{
		DischargeReadyToLeaveVo voReady = populateDataFromScreen();
		RTLSummaryVo rTLSummary = populateRTLSummary(form.getGlobalContext().Core.getCurrentCareContext());
		String[] str = null;
		if (voReady.getAuthoringInfo() == null)
		{
			str = new String[] { "Authorising HCP and Authorised Date/Time are mandatory" };
		}
		
		str=rTLSummary.validate(str);//WDEV-18622 //WDEV-18714
		
		str = voReady.validate(validateUIRules(str));
		
		if (str != null && str.length > 0 ) 
		{
			engine.showErrors(str);
			return false;
		}

		try
		{
			voReady = domain.saveReadyToLeave(voReady, rTLSummary); //WDEV-18622 
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			open();
			form.setMode(FormMode.VIEW);
			return false;
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());

			form.setMode(FormMode.VIEW);
			open();

			// Temporary fix for WDEV-8612 (this code really belongs in the
			// open() function)
			form.getGlobalContext().Clinical.seteDischargeDisableTabs(false);
			form.fireCustomControlValueChanged();

			return false;
		}
		form.getLocalContext().setSelectedRecord(voReady);
		form.getLocalContext().setEdischargeRTLSummary(rTLSummary);

		if (voReady.getCompletedOnIsNotNull())
		{
			setReadOnly();
			form.getGlobalContext().Clinical.seteDischargeCompleted(true);
		}
		else
		{
			form.getGlobalContext().Clinical.seteDischargeCompleted(false);
			form.getLocalContext().setisReadonly(false);
		}
		form.setMode(FormMode.VIEW);
		form.getGlobalContext().Clinical.seteDischargeDisableTabs(false);
		form.fireCustomControlValueChanged();

		return true;
	}

	@SuppressWarnings("deprecation")
	private String[] validateUIRules(String[] previousErrors)
	{
		ArrayList<String> errors = new ArrayList<String>();
		if (previousErrors != null && previousErrors.length > 0)
		{

			errors.addAll(Arrays.asList(previousErrors));
		}
		if (form.dtimDODisch().getValue() != null)
		{
			PartialDate pDOB;
			if (form.getGlobalContext().Core.getPatientShortIsNotNull() && form.getGlobalContext().Core.getPatientShort().getDobIsNotNull())
			{
				pDOB = form.getGlobalContext().Core.getPatientShort().getDob();
				Integer day = pDOB.getDay();
				if (day == null)
					day = 1;
				Integer month = pDOB.getMonth();
				if (month == null)
					month = 1;
				
				DateTime dtimDOB = new DateTime(new Date(pDOB.getYear()-1900,month-1,day,0,0));	
				
				if (form.dtimDODisch().getValue().isLessThan(dtimDOB))
				{
					errors.add("Discharge Date cannot be before patient DOB");
				}
			}
			if (form.dtimDODisch().getValue().isGreaterThan(new DateTime()))
			{
				errors.add("Discharge Date cannot be in the future");
			}
		}
		if (form.dtimDODisch().getValue() == null)
		{
			errors.add("Discharge Date is mandatory");
		}
		
		if (errors != null && errors.size() > 0)
		{
			String[] result = new String[errors.size()];
			errors.toArray(result);
			return result;
		}
		return null;
	}

	private void populateWards()
	{
		ILocation currentLocation = domain.getCurrentLocation();

		if (currentLocation == null)
			return;

		LocationLiteVoCollection wards = domain.listActiveWardsForHospitalLite((LocationRefVo) currentLocation);
		for (int i = 0; i < wards.size(); i++)
			form.cmbDischWard().newRow(wards.get(i), wards.get(i).getName());
	}

	public void initialise()
	{
		if (form.getLocalContext().getbInitialised() == null)
		{
			initializeComponent();
			form.getLocalContext().setbInitialised(Boolean.TRUE);
		}
		open();
	}

	private void manageReadOnly()
	{
		if (form.getMode().equals(FormMode.VIEW))
			form.btnEdit().setVisible(true);

		if (form.getLocalContext().getisReadonlyIsNotNull() && form.getLocalContext().getisReadonly() && form.getMode().equals(FormMode.EDIT))
		{
			activatedeactivatecontrols(form.getMode().equals(FormMode.EDIT));
		}
		// form.btnEdit().setVisible(false);
	}

	private void activatedeactivatecontrols(boolean mode)
	{
		//form.txtNurseEnabledDischargeInstruction().setEnabled(mode);//WDEV-18775 
		form.txtNurseEnabledConfirmation().setEnabled(mode);
		form.dtimDODisch().setEnabled(mode);
		form.cmbDischMethod().setEnabled(mode);
		form.cmbDischDest().setEnabled(mode);
		form.btnPrintDisch().setEnabled(mode);

		if (FormMode.EDIT.equals(form.getMode()))
		{
			form.btnSave().setVisible(mode);
			form.txtNurseEnabledDischargeInstruction().setEnabled(domain.getNurseEnabledDischargeInstructionFromFuturePlan(form.getGlobalContext().Core.getCurrentCareContext())); //WDEV-18775 
		}
		form.btnSave().setEnabled(mode);

		form.cmbDischWard().setEnabled(mode);
		form.cmbDischSpec().setEnabled(mode);
		form.ccDischCons().setMode(FormMode.EDIT);
		form.ccDischCons().setEnabled(mode);
		form.ccAuthoring().setEnabledAuthoringHCP(mode);
		form.ccAuthoring().setEnabledDateTime(mode);
		
		manageCheckBox(form.getLocalContext().getSelectedRecord().getHasPatientReceivedCopyOfDischargeIsNotNull(), mode);
		
		checkIfCheckBoxShouldBeDisplayedAnyway(form.getLocalContext().getSelectedRecord());
	}

	public void initializeComponent()
	{
		setTooltips();
		
		populateWards();
		form.lblMessage().setVisible(form.getLocalContext().getSelectedRecordIsNotNull()&& form.getLocalContext().getSelectedRecord().getDischargeDetailsIsNotNull() && !(DischargeLetterStatus.GENERATED.equals(form.getLocalContext().getSelectedRecord().getDischargeDetails().getDischargeLetterStatus()))); //WDEV-18845
		form.lblMessage().setTextColor(Color.Red);//WDEV-18622
		form.ccDischCons().initialize(MosType.MEDIC);
		form.ccAuthoring().setIsRequiredPropertyToControls(true);
		form.ccAuthoring().setLabels(AuthoringLabelType.AUTHORISING); //WDEV-18622
		form.ccAuthoring().initializeComponent(HcpDisType.MEDICAL);
		
		initializeSummaryDynGrid(); //WDEV-18916
		clearInstanceControls();
		
		form.getGlobalContext().Clinical.seteDischargeCompleted(false);

		form.getLocalContext().setisReadonly(false);

		form.getLocalContext().setbInitialised(null);
	}

	private void initializeSummaryDynGrid()
	{
		form.dynGrdEdischSummary().clear();
		form.dynGrdEdischSummary().setHeaderHeight(0);
		form.dynGrdEdischSummary().setSelectable(false);
		form.getLocalContext().setSummaryMedicationParamColour(Color.Default); //WDEV-19000
		
		DynamicGridColumn col = form.dynGrdEdischSummary().getColumns().newColumn("", COL_SUMMARY_PARAM_NAME);
		col.setWidth(250); //WDEV-19271
		col.setCanGrow(Boolean.TRUE);
		col.setReadOnly(Boolean.TRUE);
		col.setSortMode(SortMode.AUTOMATIC);
		
	
		col = form.dynGrdEdischSummary().getColumns().newColumn("",COL_SUMMARY_PARAM_VALUE);
		col.setWidth(-1);
		col.setAlignment(Alignment.RIGHT);
		col.setCanGrow(Boolean.TRUE);
		col.setReadOnly(Boolean.TRUE);
	}
	
	private DynamicGridColumn getColumn(Integer colFieldName) 
	{
		return form.dynGrdEdischSummary().getColumns().getByIdentifier(colFieldName);
	}	
	private void setTooltips()
	{
		EDischargeHINT lkpHint = new EDischargeHINT();

		lkpHint.setId(-1743); // Date of Discharge (Ready to Leave)
		FieldHelpVo voHint = domain.getHintByLookupID(lkpHint);
		if (voHint != null)
			form.imbDODisch().setTooltip(voHint.getHelpText());

		lkpHint.setId(-1745); // Print Discharge (Ready to Leave)
		voHint = domain.getHintByLookupID(lkpHint);
		if (voHint != null)
			form.imbPrintDisch().setTooltip(voHint.getHelpText());

	}

	public void open()
	{
		clearInstanceControls();

		manageCheckBox(false, false);

		form.btnPrintDisch().setEnabled(false);
		form.btnPrintDisch().setVisible(false);
		form.imbPrintDisch().setEnabled(false);
		form.imbPrintDisch().setVisible(false);
		DischargeReadyToLeaveVo voReady = domain.getReadyToLeave(form.getGlobalContext().Core.getCurrentCareContext());
		RTLSummaryVo rTLSummary = domain.getRTLSummaryForCareContext(form.getGlobalContext().Core.getCurrentCareContext()); //WDEV-18622
		DischargeMedicationDetailsVo voMeds = domain.getMedication(form.getGlobalContext().Core.getCurrentCareContext()); //WDEV-18916
		if (voReady != null)
		{
			form.getLocalContext().setisReadonly(voReady.getCompletedOnIsNotNull() ? true : false);
			populateScreenFromData(voReady);
			
			form.lblMessage().setVisible(form.getLocalContext().getSelectedRecordIsNotNull()&& form.getLocalContext().getSelectedRecord().getDischargeDetailsIsNotNull() && !(DischargeLetterStatus.GENERATED.equals(form.getLocalContext().getSelectedRecord().getDischargeDetails().getDischargeLetterStatus()))); //WDEV-18845
			if (form.getMode().equals(FormMode.VIEW))
			//	&& (voReady.getHasPatientReceivedCopyOfDischarge() == null
			//		|| (voReady.getHasPatientReceivedCopyOfDischargeIsNotNull()	&&  ! voReady.getHasPatientReceivedCopyOfDischarge()) ) )
			{
				if(form.getLocalContext().getCurrentDischargeReportDetailVoIsNotNull()
					&& form.getLocalContext().getCurrentDischargeReportDetailVo().getIsClinicalDetailsCompleteIsNotNull()
					&& form.getLocalContext().getCurrentDischargeReportDetailVo().getIsClinicalDetailsComplete())
				{
					DischargeDetailsVo volocalDD = domain.getDischargeDetails(form.getGlobalContext().Core.getCurrentCareContext());
					if(form.getLocalContext().getCurrentDischargeReportDetailVoIsNotNull()
						&& volocalDD !=null//WDEV-12369
						&& volocalDD.getDateOfDischargeIsNotNull())
					//	&& (volocalDD.getDischargeLetterStatus() == null
					//		|| (volocalDD.getDischargeLetterStatusIsNotNull()
					//				&& volocalDD.getDischargeLetterStatus().equals(DischargeLetterStatus.IN_PROGRESS)) ) )
					{
						if (voMeds != null
							&&( (voMeds.getTTARequiredIsNotNull()
									&& voMeds.getTTARequired().equals(TTORequired.REQUIRED)
									&& voMeds.getTTAsIsNotNull()
									&& voMeds.getTTAs().size() > 0)
									|| (voMeds.getTTARequiredIsNotNull()
											&& voMeds.getTTARequired().equals(TTORequired.NOT_REQUIRED))) )
						{
							form.btnPrintDisch().setEnabled(true);
							form.btnPrintDisch().setVisible(true);
							form.imbPrintDisch().setEnabled(false); //WDEV-18916 the button click does nothing
							form.imbPrintDisch().setVisible(true);
						}
					}
				}
			}
		}

		if (voReady == null)
		{
			DischargeDetailsVo voDD = domain.getDischargeDetails(form.getGlobalContext().Core.getCurrentCareContext());
			if (voDD != null)
			{
				voReady = new DischargeReadyToLeaveVo();
				//------------
				if(voDD.getNurseEnabledInstructions() == null)
				{
					NurseEnabledInstructionsVo voNrs  = domain.getNurseEnabledInstructions(form.getGlobalContext().Core.getCurrentCareContext());
					if(voNrs != null)
					{
						voDD.setNurseEnabledInstructions(voNrs);
					}
					
				}
				//-----------

				voReady.setDischargeDetails(voDD);
				
				if (form.getGlobalContext().Core.getEpisodeofCareShort().getResponsibleHCPIsNotNull() && voDD.getDischargingConsultant() == null)
				{
					form.ccDischCons().setValue(form.getGlobalContext().Core.getEpisodeofCareShort().getResponsibleHCP());
					form.cmbDischSpec().setValue(form.getGlobalContext().Core.getEpisodeofCareShort().getSpecialty());
				}
				else
				{
					form.ccDischCons().setValue(voDD.getDischargingConsultant());
					form.cmbDischSpec().setValue(voDD.getDischargingSpecialty());
				}
				
//				 TODO			form.txtNurseEnabledDischargeInstruction().setValue(voDD.getNurseEnabledInstructions());
				//-------------------
				if(voDD.getNurseEnabledInstructions() != null)
					form.txtNurseEnabledDischargeInstruction().setValue(voDD.getNurseEnabledInstructions().getNurseEnabledInstructions());
				//-------------------
			}

		}
		form.getLocalContext().setSelectedRecord(voReady);
		//WDEV-18622
		form.getLocalContext().setEdischargeRTLSummary(rTLSummary);
		populateRTLSummaryControls(form.getLocalContext().getEdischargeRTLSummary());
		populateEDischSummaryGridFromRTLData(form.getLocalContext().getEdischargeRTLSummary(),voMeds); //WDEV-18916
		manageReadOnly();
	}

	private String buildReport()
	{
		CareContextShortVo currentCareContext = form.getGlobalContext().Core.getCurrentCareContext();
		Object[] obj = null;
		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());
		String url = "";

		Integer reportID = 163;
		obj = domain.getSystemReportAndTemplate(reportID);
		client.addSeed(new SeedValue("CARE_CONTEXT", currentCareContext.getID_CareContext(), Integer.class));

		if (obj == null || obj.length < 2)
		{
			engine.showMessage("I could not get the report and template !");
			return "";
		}

		if (obj[0] == null || obj[1] == null)
		{
			engine.showMessage("The report has not been deployed !");
			return "";
		}

		try
		{
			url = client.buildReportAsUrl((String) obj[0], (String) obj[1], urlReportServer, "PDF", "", 1);
			if (url != null)
			{
				engine.openUrl(url);
			}
		}
		catch (QueryBuilderClientException e1)
		{
			engine.showMessage("Error creating report: " + e1.getMessage());
			return "";
		}
		return "";
	}

	public void setReadOnly()
	{
		form.getLocalContext().setisReadonly(form.getGlobalContext().Clinical.geteDischargeCompleted());
		manageReadOnly();
	}
}
