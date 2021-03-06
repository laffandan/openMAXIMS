//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.20 build 40726.1130)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.alerts;

import ims.configuration.gen.ConfigFlag;
import ims.core.clinical.vo.PatientAlertRefVo;
import ims.core.helper.ResetPIDBarHelper;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.PatientAlert;
import ims.core.vo.PatientAlertCollection;
import ims.core.vo.PatientNoAlertInfoVo;
import ims.core.vo.PatientShort;
import ims.core.vo.RecordingUserInformationVo;
import ims.core.vo.lookups.AlertType;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.PatientAlertStatus;
import ims.core.vo.lookups.SourceofInformation;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.cn.data.TreeNode;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateFormat;
import ims.framework.utils.DateTime;
import ims.framework.utils.PartialDate;
import ims.vo.LookupInstVo;

import java.util.ArrayList;
import java.util.List;

public class Logic extends BaseLogic
{
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.FormOpenException //WDEV-14413
	{
		initialise();	
		initializeAlertsForTriageForm(args);//	WDEV-14413
	}
	
	//WDEV-14413
	private void initializeAlertsForTriageForm(Object[] args) 
	{
		if(isAlertForTriage())
		{
			if(args == null || args.length == 0)
			{
				newAlert();
			}
			else if(args[0] instanceof PatientAlertRefVo)
			{
				selectionChanged((PatientAlertRefVo) args[0]);
				editAlert();
			}
		}
	}
	
	private void initialise() 
	{
		form.ctnDetails().cmbSource().setRequired(true);
		
		loadCategories(); //Hierarchichal functionality - Select Alert Category then Alert Type
		
		form.groupFilter().setValue(GenForm.groupFilterEnumeration.rdoActive);
		
		if(form.getGlobalContext().Core.getPatientShort() == null) //to safeguard if this page is made available elsewhere
		{
			engine.showMessage("No Patient ID found");
			return;
		}	
		
		open();
		initializeHasNoKnownAlerts();		
	}

	private void initializeHasNoKnownAlerts() 
	{
		PatientNoAlertInfoVo voPatientNoAlertInfo = domain.getPatientNoAlertInfo(form.getGlobalContext().Core.getPatientShort());		
		form.getLocalContext().setPatientNoAlertInfoVo(voPatientNoAlertInfo);			
		checkNoAlertStatus(voPatientNoAlertInfo);
	}

	private void checkNoAlertStatus(PatientNoAlertInfoVo voPatientNoAlertInfo) 
	{
		if(voPatientNoAlertInfo != null 
			&& voPatientNoAlertInfo.getAlertStatusIsNotNull() 
			&& voPatientNoAlertInfo.getAlertStatus().equals(PatientAlertStatus.NOKNOWNALERTS))
		{
			form.lblNoKnownAllerts().setVisible(true);
			form.lblNoKnownAllerts().setTooltip(voPatientNoAlertInfo.createInfoTooltip().toString());
			
			if (form.getMode().equals(FormMode.VIEW))
				form.btnUpdate().setEnabled(true);
			
			populateScreenFromData(voPatientNoAlertInfo);
		}
		else
		{
			form.lblNoKnownAllerts().setVisible(false);
			form.lblNoKnownAllerts().setTooltip("");
			form.btnUpdate().setEnabled(false);
		}
	}

	private void loadCategories() 
	{		
		TreeNode[] coll = LookupHelper.getAlertType(domain.getLookupService()).getRootNodes();
				
		if(coll != null)
		{
			for(int i=0;i<coll.length;i++)
			{
				AlertType item = (AlertType)coll[i];
				if(item.isActive())
					form.ctnDetails().cmbCategory().newRow(item, item.getText());
			}
		}
	}

	protected void onRadioButtongroupFilterValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		populateGrid();
		this.clearCurScreen();
		form.btnUpdate().setEnabled(false);
		form.btnInactivate().setVisible(false);		
	}
	
	protected void onGrdAlertsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.grdAlerts().getValue() == null)////	WDEV-14413
			return;
		
		selectionChanged(form.grdAlerts().getValue());	//	WDEV-14413
	}

	//	WDEV-14413
	private void selectionChanged(PatientAlertRefVo patientAlertRef) 
	{
		PatientAlert voAlert = domain.getPatientAlert(patientAlertRef);//	WDEV-14413
		form.getLocalContext().setAlertRecord(voAlert);
		form.grdAlerts().setValue(form.getLocalContext().getAlertRecord());//WDEV-15656
		if (form.getMode().equals(FormMode.EDIT)) //WDEV-18130  removed Illegal Control State change Warning
		{
			form.ctnDetails().cmbSource().setEnabled(true);
		}	
		if(voAlert != null)
		{
			this.populateScreenFromData(voAlert);
			
			form.ctnDetails().cmbRecordingHCP().setValue(null);	
			form.ctnDetails().dtimRecordingDateTime().setValue(null);
			if(voAlert.getRecordingInformationIsNotNull()){
				MemberOfStaffLiteVo mos = voAlert.getRecordingInformation().getRecordingUser();
				if(mos!=null){
					form.ctnDetails().cmbRecordingHCP().newRow(mos, mos.toString());
					form.ctnDetails().cmbRecordingHCP().setValue(mos);	
				}
				form.ctnDetails().dtimRecordingDateTime().setValue(voAlert.getRecordingInformation().getRecordingDateTime());
			}
			
			if(voAlert.getIsCurrentlyActiveAlert() != null)
			{
				if(voAlert.getIsCurrentlyActiveAlert().booleanValue())
				{
					form.btnUpdate().setEnabled(true);	
					form.btnInactivate().setVisible(true);
					form.getContextMenus().getGenericGridUpdateItem().setVisible(true);
				}
				else{
					form.btnUpdate().setEnabled(false);	
					form.btnInactivate().setVisible(false);
					form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
					}
			}
			
			form.ctnDetails().setCollapsed(false);
		}
	}
	
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		editAlert();
	}
	
	private void editAlert() 
	{
		form.ctnDetails().cmbSource().setFocus();
		form.setMode(FormMode.EDIT);
		
		if (form.getLocalContext().getPatientNoAlertInfoVoIsNotNull()
			&& form.getLocalContext().getPatientNoAlertInfoVo().getAlertStatusIsNotNull()
			&& form.getLocalContext().getPatientNoAlertInfoVo().getAlertStatus().equals(PatientAlertStatus.NOKNOWNALERTS)) 
		{
			form.ctnDetails().chkNoKnownAlerts().setVisible(true);
			form.ctnDetails().chkNoKnownAlerts().setEnabled(false);
			form.ctnDetails().chkNoKnownAlerts().setValue(true);
		}

		form.btnUpdate().setEnabled(false);
		form.btnInactivate().setVisible(false);
		
		enableDetailsControls(true);
		form.getLocalContext().setAlertRecord(form.grdAlerts().getValue());
		form.ctnDetails().setcustomControlAuthoringInfoEnabled(false);
	
		form.getContextMenus().hideAllGenericGridMenuItems();

		checkNoAlertStatus(form.getLocalContext().getPatientNoAlertInfoVo());
		
		if(form.ctnDetails().chkNoKnownAlerts().getValue())
			enableDetailsControls(false);
		
		alertsValueChanged();

	}

	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newAlert();
	}
	
	private void newAlert() 
	{
		form.ctnDetails().cmbSource().setFocus();
		form.setMode(FormMode.EDIT); 
		
		if( form.grdAlerts().getRows() != null
			&& form.grdAlerts().getRows().size() > 0) 
		{
			form.ctnDetails().chkNoKnownAlerts().setVisible(false);
			form.ctnDetails().chkNoKnownAlerts().setValue(false);
		}
		else if(form.getLocalContext().getPatientNoAlertInfoVo() == null)
		{
			form.ctnDetails().chkNoKnownAlerts().setVisible(true);
			form.ctnDetails().chkNoKnownAlerts().setEnabled(true);
			form.ctnDetails().chkNoKnownAlerts().setValue(false);
		}
		else if (form.getLocalContext().getPatientNoAlertInfoVoIsNotNull()
				&& form.getLocalContext().getPatientNoAlertInfoVo().getAlertStatusIsNotNull()
				&& form.getLocalContext().getPatientNoAlertInfoVo().getAlertStatus().equals(PatientAlertStatus.NOKNOWNALERTS)) 
		{
			form.ctnDetails().chkNoKnownAlerts().setVisible(false);
			form.ctnDetails().chkNoKnownAlerts().setEnabled(false);
			form.ctnDetails().chkNoKnownAlerts().setValue(false);
		}
		else if(form.getLocalContext().getPatientNoAlertInfoVo().getAlertStatus() == null) 
		{
			form.ctnDetails().chkNoKnownAlerts().setVisible(true);
			form.ctnDetails().chkNoKnownAlerts().setEnabled(true);
			form.ctnDetails().chkNoKnownAlerts().setValue(false);
		}
		else if( ! form.getLocalContext().getbActiveAlerts() 
			&& form.getLocalContext().getPatientNoAlertInfoVo().getAlertStatus().equals(PatientAlertStatus.HASALERTS))
		{
			form.ctnDetails().chkNoKnownAlerts().setVisible(true);
			form.ctnDetails().chkNoKnownAlerts().setEnabled(true);
			form.ctnDetails().chkNoKnownAlerts().setValue(false);
		}
		else
		{
			form.ctnDetails().chkNoKnownAlerts().setVisible(false);
			form.ctnDetails().chkNoKnownAlerts().setValue(false);
		}
		
		this.clearCurScreen();
		
		form.btnUpdate().setEnabled(false);
		form.btnInactivate().setVisible(false);
		
		enableDetailsControls(true);
		
		form.ctnDetails().customControlAuthoringInfo().initializeComponent();
		form.ctnDetails().setcustomControlAuthoringInfoEnabled(true);
		form.ctnDetails().customControlAuthoringInfo().setIsRequiredPropertyToControls(Boolean.TRUE);

		Object mos = domain.getMosUser();
		if(mos != null){
			form.ctnDetails().cmbRecordingHCP().newRow((MemberOfStaffLiteVo)mos, mos.toString());
			form.ctnDetails().cmbRecordingHCP().setValue((MemberOfStaffLiteVo)mos);
		}
		form.ctnDetails().dtimRecordingDateTime().setValue(new DateTime());
		
		form.getLocalContext().setAlertRecord(new PatientAlert());
		form.ctnDetails().setCollapsed(false);
		
		form.getContextMenus().hideAllGenericGridMenuItems();
	}

	protected void onBtnInactivateClick() throws PresentationLogicException 
	{ 
		form.getGlobalContext().Core.setYesNoDialogMessage("Are you sure you wish to make this record inactive");
		engine.open(form.getForms().Core.AlertComment);	
	}

	private String[] validateUIRules() 
	{
		List<String> errors = new ArrayList<String>();
		PartialDate dateIdentified = form.ctnDetails().pdtIdentified().getValue();
		
		if(dateIdentified != null)
		{
			if(dateIdentified.isGreaterThan(new Date()))
			{
				errors.add("'Date Identified' can not be in the future");				
			}
			
			PartialDate pdob = form.getGlobalContext().Core.getPatientShort().getDob();			
			if(pdob != null)
			{
				PartialDate dateToCompare = new PartialDate(dateIdentified.getYear(), dateIdentified.getMonth() == null ? pdob.getMonth() : dateIdentified.getMonth(), dateIdentified.getDay() == null ? pdob.getDay() : dateIdentified.getDay());
				if (dateToCompare.isLessThan(pdob))
					errors.add("'Date Identified' cannot be previous to DOB");									
			}
		}				
		//WDEV-18130
		if (form.ctnDetails().customControlAuthoringInfo().getErrors() != null) 
		{
			errors.add(form.ctnDetails().customControlAuthoringInfo().getErrors()); 
		}
		
		String[] searchErrors = new String[errors.size()];
		errors.toArray(searchErrors);
		return searchErrors;		
	}

	protected void onBtnSaveClick() throws PresentationLogicException 
	{
		if(form.ctnDetails().chkNoKnownAlerts().getValue())
		{
			if ( ! savePatientCoreClinicalData(true))
				return;

			form.ctnDetails().chkNoKnownAlerts().setValue(false);
			open();
			
			return;
		}
				
		PatientAlert voPatientAlert = form.getLocalContext().getAlertRecord();
		this.populateDataFromScreen(voPatientAlert);
		
		populateCoreClinicalData(false);
		PatientNoAlertInfoVo voPatientNoAlertInfo = form.getLocalContext().getPatientNoAlertInfoVo();
		
		String[] errors = voPatientNoAlertInfo.validate(validateUIRules());
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return;
		}
		errors = voPatientAlert.validate(validateUIRules());
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return;
		}
		
		try 
		{
			domain.savePatientAlert(voPatientAlert, voPatientNoAlertInfo);
		}
		catch (StaleObjectException e) 
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			handleExceptionThrown();
			return;
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			handleExceptionThrown();
			return;
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage(e.getMessage());
			handleExceptionThrown();
			return;
		}
		
		initializeHasNoKnownAlerts();
		open();
	}

	private void handleExceptionThrown() 
	{
		populateGrid();
		initializeHasNoKnownAlerts();
		this.clearCurScreen();
		form.setMode(FormMode.VIEW);
		form.btnUpdate().setEnabled(false);
	}

	private void open()
	{
		form.setMode(FormMode.VIEW);	
		this.clearCurScreen();
		
		populateGrid();
		
		loadCategories();
		form.btnUpdate().setEnabled(false);
		form.btnInactivate().setVisible(false);
		
		checkNoAlertStatus(form.getLocalContext().getPatientNoAlertInfoVo());		
	}

	private String createRowTooltip(PatientAlert alert)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<b>Comment : </b>");
		sb.append(alert.getCommentsIsNotNull() ? alert.getComments().toString() : "");
		sb.append("<br>");
		sb.append("<b>Date Identified : </b>");
		sb.append(alert.getDateIdentifiedIsNotNull() ? alert.getDateIdentified().toString() : "");
		sb.append("<br>");
		sb.append("<b>Authoring Info : </b>");
		sb.append(alert.getAuthoringInformationIsNotNull() ? alert.getAuthoringInformation().toString(" - ") : "");
		sb.append("<br>");
		sb.append("<b>Recording Info : </b>");
		sb.append(alert.getRecordingInformationIsNotNull() ? alert.getRecordingInformation().toString(" - ") : "");
		sb.append("<br>");

		return sb.toString();
	}

	private String createInactivateTooltip(PatientAlert alert)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<b>Inactive Comment : </b>");
		sb.append(alert.getInactivationCommentsIsNotNull() ? alert.getInactivationComments().toString() : "");
		sb.append("<br>");
		sb.append("<b>Inactivated Info : </b>");
		sb.append(alert.getInactivationAuthoringInfoIsNotNull() ? alert.getInactivationAuthoringInfo().toString(" - ") : "");
		sb.append("<br>");
		sb.append("<b>Recording Info : </b>");
		sb.append(alert.getRecordingInformationIsNotNull() ? alert.getRecordingInformation().toString(" - ") : "");
		sb.append("<br>");

		return sb.toString();
	}

	private boolean savePatientCoreClinicalData(boolean bNoKnownAlerts) 
	{
		populateCoreClinicalData(bNoKnownAlerts);
		PatientNoAlertInfoVo voPatientNoAlertInfo = form.getLocalContext().getPatientNoAlertInfoVo();
		
		String[] errors = voPatientNoAlertInfo.validate();
		
		if(errors != null)
		{	
			engine.showErrors("Validation Errors", errors);
			return false;
		}
		
		try
		{
			voPatientNoAlertInfo = domain.savePatientCoreClinicalData(voPatientNoAlertInfo);
			form.getLocalContext().setPatientNoAlertInfoVo(voPatientNoAlertInfo);
		} 
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			initializeHasNoKnownAlerts();

			return true;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			initializeHasNoKnownAlerts();
			return true;
		}
		return true;
	}

	private void populateCoreClinicalData(boolean noKnownAlerts) 
	{
		PatientNoAlertInfoVo voPatientNoAlertInfo = form.getLocalContext().getPatientNoAlertInfoVo();
		if(voPatientNoAlertInfo==null)
			voPatientNoAlertInfo = new PatientNoAlertInfoVo();
		
		voPatientNoAlertInfo.setPatient(form.getGlobalContext().Core.getPatientShort());
		
		voPatientNoAlertInfo.setAuthoringInformation(form.ctnDetails().customControlAuthoringInfo().getValue());
		if(voPatientNoAlertInfo.getRecordingInformation()==null)
		{
			//WDEV-12901 set Recording Information
			RecordingUserInformationVo voRecordingUserInformation = new RecordingUserInformationVo();
			Object mos = domain.getMosUser();
			if(mos != null)
				voRecordingUserInformation.setRecordingUser((MemberOfStaffLiteVo)mos);
			voRecordingUserInformation.setRecordingDateTime(new DateTime());
			voPatientNoAlertInfo.setRecordingInformation(voRecordingUserInformation);
		}
		//wdev-16756
		if(voPatientNoAlertInfo.getAuthoringInformation()==null)
		{
			AuthoringInformationVo voAuthor = new AuthoringInformationVo();
			voAuthor.setAuthoringDateTime(new DateTime());
			voAuthor.setAuthoringHcp((HcpLiteVo)domain.getHcpLiteUser());
			voPatientNoAlertInfo.setAuthoringInformation(voAuthor);
		}

		voPatientNoAlertInfo.setNoAlertSourceofInformation(form.ctnDetails().cmbSource().getValue());
		voPatientNoAlertInfo.setWhenIdentified(form.ctnDetails().pdtIdentified().getValue());
		
		if(noKnownAlerts)
			voPatientNoAlertInfo.setAlertStatus(PatientAlertStatus.NOKNOWNALERTS);
		else
			voPatientNoAlertInfo.setAlertStatus(PatientAlertStatus.HASALERTS);
		
		form.getLocalContext().setPatientNoAlertInfoVo(voPatientNoAlertInfo);
	}

	protected void onBtnCancelClick() throws PresentationLogicException 
	{
		form.setMode(FormMode.VIEW);	
		form.btnInactivate().setVisible(false);
		form.btnUpdate().setEnabled(false);
		this.clearCurScreen();
		
		loadCategories();
		populateGrid();
		initializeHasNoKnownAlerts();
		checkNoAlertStatus(form.getLocalContext().getPatientNoAlertInfoVo());
	}

	protected void onCmbCategoryValueChanged() throws PresentationLogicException 
	{
		form.ctnDetails().cmbAlerts().clear();

		if( ConfigFlag.UI.BED_INFO_UI_TYPE.getValue().equals("WST"))
		{
			if (form.getMode().equals(FormMode.EDIT))//WDEV-18130  removed Illegal Control State change Warning
			{	
				form.ctnDetails().cmbSource().setEnabled(true);
			}
			defaultSourceCombo();
		}
		
		if(form.ctnDetails().cmbCategory().getValue() == null) //for blank selection
			return;

		ArrayList coll = form.ctnDetails().cmbCategory().getValue().getChildInstances();
		AlertType type = null;
		for(int i=0;i<coll.size();i++)
		{
			type = (AlertType)coll.get(i);
			if(type.isActive())
				form.ctnDetails().cmbAlerts().newRow((AlertType)coll.get(i), coll.get(i).toString());
		}
	}
	
	private void populateGrid()
	{
		// clearing rie local context and grid
		form.getLocalContext().setAlertRecord(null);
		form.grdAlerts().getRows().clear();		
		
		boolean hasActiveAllerts = false;
		
		PatientAlertCollection voColl = new PatientAlertCollection();
		PatientAlertCollection voCollection = domain.listPatientAlerts(form.getGlobalContext().Core.getPatientShort(), Boolean.FALSE);
		
		if(voCollection != null &&
				voCollection.size() > 0)
		{
			hasActiveAllerts = true;
			if (form.groupFilter().getValue().equals(GenForm.groupFilterEnumeration.rdoActive))
			{
				for (int i = 0; i < voCollection.size(); i++) 
				{
					if(voCollection.get(i).getIsCurrentlyActiveAlert())
					{
						voColl.add(voCollection.get(i));
					}
				}
			}
			else
			{
				voColl = voCollection;
			}
		}	
		
		form.grdAlerts().getRows().clear();
		form.grdAlerts().setValue(null); //used to clear selection in grid bug					
		
		if(voColl != null)
		{			
			GenForm.grdAlertsRow row = null;
			for(int i=0;i<voColl.size();i++)
			{
				row = form.grdAlerts().getRows().newRow();
				row.setValue(voColl.get(i));

				String tooltipStr = createRowTooltip(voColl.get(i));
				
				if(voColl.get(i).getAlertType() != null)
				{
					row.setColAlert(voColl.get(i).getAlertType().toString());
					if(voColl.get(i).getAlertType().getParent() != null)
					{
						row.setColCategory(voColl.get(i).getAlertType().getParent().toString());
					}
				}
				row.setTooltipForColAlert(tooltipStr);
				row.setTooltipForColCategory(tooltipStr);
				
				if(voColl.get(i).getSourceofInformation() != null)
				{
					row.setColSource(voColl.get(i).getSourceofInformation().toString());
				}
				row.setTooltipForColSource(tooltipStr);

				if(voColl.get(i).getSysInfo() != null && voColl.get(i).getSysInfo().getCreationDateTime()!= null && voColl.get(i).getSysInfo().getCreationDateTime().getDate() != null)
				{
					row.setColDate(voColl.get(i).getSysInfo().getCreationDateTime().getDate().toString(DateFormat.STANDARD));
				}
				row.setTooltipForColDate(tooltipStr);

				if (voColl.get(i).getSysInfoIsNotNull() && voColl.get(i).getSysInfo().getLastupdateUser() != null)
				{
					row.setColAudit(form.getImages().Core.EditDisabled);
					row.setTooltipForColAudit("This record has been updated.");
				}

				if(voColl.get(i).getIsCurrentlyActiveAlert().booleanValue() == true)
				{
					row.setColActive(form.getImages().Core.AnswerBox_Yes);
					hasActiveAllerts = true;
					row.setTooltipForColActive(tooltipStr);
				}
				else
				{
					row.setColActive(form.getImages().Core.AnswerBox_No);
					row.setTooltipForColActive(createInactivateTooltip(voColl.get(i)));
					row.setBackColor(Color.LightGray);
				}

			}
		}
		
		setToolBarAlerts(hasActiveAllerts);
		form.getLocalContext().setbActiveAlerts(new Boolean(hasActiveAllerts));
		PatientShort patShort = form.getGlobalContext().Core.getPatientShort();
		patShort.setHasAlerts(new Boolean(hasActiveAllerts));
		form.getGlobalContext().Core.setPatientShort(patShort);
		
		form.grdAlerts().setValue(form.getLocalContext().getAlertRecord());
		
		if(form.grdAlerts().getValue() != null)
			form.ctnDetails().setCollapsed(false);
		else
			form.ctnDetails().setCollapsed(true);
		
		form.getContextMenus().hideAllGenericGridMenuItems();
		form.getContextMenus().getGenericGridAddItem().setVisible(true);
		form.getContextMenus().getGenericGridAddItem().setText("New");
		setToolBarAlerts(form.getLocalContext().getbActiveAlertsIsNotNull() ? form.getLocalContext().getbActiveAlerts() : false);
	}
	
	protected void populateScreenFromData(PatientAlert voPatAlert)
	{
		super.populateScreenFromData(voPatAlert);
		
		
		if(voPatAlert.getAuthoringInformationIsNotNull())
			form.ctnDetails().customControlAuthoringInfo().setValue(voPatAlert.getAuthoringInformation());
		if(voPatAlert.getAlertType() != null && voPatAlert.getAlertType().getParent() != null && voPatAlert.getAlertType().getParent().getText()!= null)
		{
			form.ctnDetails().cmbCategory().newRow(voPatAlert.getAlertType().getParent(), voPatAlert.getAlertType().getParent().getText());
			form.ctnDetails().cmbCategory().setValue(voPatAlert.getAlertType().getParent());
		}
		try 
		{ 	onCmbCategoryValueChanged();} 
		catch (PresentationLogicException e) {} 
		
		form.ctnDetails().cmbAlerts().newRow(voPatAlert.getAlertType(), voPatAlert.getAlertType().getText());
		form.ctnDetails().cmbAlerts().setValue(voPatAlert.getAlertType());
		if (form.getMode().equals(FormMode.EDIT))
				alertsValueChanged();
		
		if(voPatAlert.getIsCurrentlyActiveAlert().booleanValue() == true)
			form.btnInactivate().setVisible(true);
	}
	
	protected void populateScreenFromData(PatientNoAlertInfoVo voNoAlert)
	{
		clearScreen();

		if (form.getMode().equals(FormMode.EDIT))
			this.form.ctnDetails().chkNoKnownAlerts().setVisible(true);
		
		this.form.ctnDetails().chkNoKnownAlerts().setValue(true);
		this.form.ctnDetails().cmbSource().setValue(voNoAlert.getNoAlertSourceofInformationIsNotNull() ? voNoAlert.getNoAlertSourceofInformation() : null);
		this.form.ctnDetails().pdtIdentified().setValue(voNoAlert.getWhenIdentifiedIsNotNull() ? voNoAlert.getWhenIdentified() : null);

		if(voNoAlert.getAuthoringInformationIsNotNull())
			form.ctnDetails().customControlAuthoringInfo().setValue(voNoAlert.getAuthoringInformation());
	
		if(voNoAlert.getRecordingInformationIsNotNull()){
			if(voNoAlert.getRecordingInformation().getRecordingUserIsNotNull()){
				form.ctnDetails().cmbRecordingHCP().newRow(voNoAlert.getRecordingInformation().getRecordingUser(), voNoAlert.getRecordingInformation().getRecordingUser().toString());
				form.ctnDetails().cmbRecordingHCP().setValue(voNoAlert.getRecordingInformation().getRecordingUser());
			}
			form.ctnDetails().dtimRecordingDateTime().setValue(voNoAlert.getRecordingInformation().getRecordingDateTime());
		}
	}

	protected PatientAlert populateDataFromScreen(PatientAlert voPatientAlert)
	{
		super.populateDataFromScreen(voPatientAlert);
		
		if(voPatientAlert.getIsCurrentlyActiveAlert() == null)
			voPatientAlert.setIsCurrentlyActiveAlert(Boolean.TRUE);	
		
		voPatientAlert.setAuthoringInformation(form.ctnDetails().customControlAuthoringInfo().getValue());
		//WDEV-12901 set Recording Information
		if(voPatientAlert.getRecordingInformation()==null){
			RecordingUserInformationVo voRecordingUserInformation = new RecordingUserInformationVo();
			voRecordingUserInformation.setRecordingUser(form.ctnDetails().cmbRecordingHCP().getValue());
			voRecordingUserInformation.setRecordingDateTime(new DateTime());
			voPatientAlert.setRecordingInformation(voRecordingUserInformation);
		}
		
		voPatientAlert.setPatient(form.getGlobalContext().Core.getPatientShort());
		
		return voPatientAlert;
	}

	void clearCurScreen()
	{
		super.clearScreen();
		form.ctnDetails().customControlAuthoringInfo().setValue(null);
		form.ctnDetails().cmbCategory().setValue(null);
		form.ctnDetails().cmbAlerts().setValue(null);
		form.ctnDetails().cmbAlerts().clear();
		form.ctnDetails().cmbRecordingHCP().setValue(null);
		form.ctnDetails().dtimRecordingDateTime().setValue(null);
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(formName.equals(form.getForms().Core.AlertComment) && result.equals(DialogResult.YES))
		{
			PatientAlert voPatientAlert = new PatientAlert(); 
			voPatientAlert = form.grdAlerts().getValue();
			voPatientAlert.setIsCurrentlyActiveAlert(Boolean.FALSE);

			voPatientAlert.setInactivationComments(form.getGlobalContext().Core.getAlertInactiveComment());
			
			AuthoringInformationVo voAuthor = new AuthoringInformationVo();
			voAuthor.setAuthoringDateTime(new DateTime());
			voAuthor.setAuthoringHcp((HcpLiteVo)domain.getHcpLiteUser());
			voPatientAlert.setInactivationAuthoringInfo(voAuthor);
			
			String[] arrErrors = voPatientAlert.validate();
			if(arrErrors != null)
			{
				engine.showErrors("Validation Errors", arrErrors);
				return;
			}
			
			try 
			{
				domain.savePatientAlert(voPatientAlert);
			} 
			catch (DomainInterfaceException e) 
			{
				engine.showMessage(e.getMessage());

				populateGrid();
				open();
				this.clearCurScreen();
				return;
			} 
			catch (StaleObjectException e) 
			{
				
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				populateGrid();
				open();
				
				this.clearCurScreen();
				return;
			}
			
			open();
			
			/*if(!form.getLocalContext().getbActiveAlerts()){
				PatientNoAlertInfoVo voPatientNoAlertInfo = form.getLocalContext().getPatientNoAlertInfoVo();
				if(voPatientNoAlertInfo==null || voPatientNoAlertInfo.getAlertStatus()==null)
					return;
				
				voPatientNoAlertInfo.setPatient(form.getGlobalContext().Core.getPatientShort());
				
				voPatientNoAlertInfo.setAlertStatus(null);
				
				try
				{
					voPatientNoAlertInfo = domain.savePatientCoreClinicalData(voPatientNoAlertInfo);
					form.getLocalContext().setPatientNoAlertInfoVo(voPatientNoAlertInfo);
				} 
				catch (StaleObjectException e)
				{
					engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				}
				catch (UniqueKeyViolationException e)
				{
					engine.showMessage(e.getMessage());
				}
				catch (DomainInterfaceException e)
				{
					engine.showMessage(e.getMessage());
				}		
			}*/
		}
	}

	private void setToolBarAlerts(boolean bAlertsExist)
	{
		if(bAlertsExist)
		{
			if(form.getGlobalContext().Core.getPatientShort().getHasAlerts() != null 
				&& form.getGlobalContext().Core.getPatientShort().getHasAlerts().booleanValue() == true)
			{
				resetPIDBarText();
				return;
			}
			//else
			//{
			engine.clearAlertsByType(ims.alerts.PatientAlert.class);
			engine.addAlert(new ims.alerts.PatientAlert("The patient has alerts."));					
			//}
		}
		else
		{
			engine.clearAlertsByType(ims.alerts.PatientAlert.class);
			form.getGlobalContext().Core.getPatientShort().setHasAlerts(Boolean.FALSE);
		}
		resetPIDBarText();
	}
	private void resetPIDBarText()
	{
		if (form.getGlobalContext().Core.getPatientShort() == null)
			return;

		new ResetPIDBarHelper(engine, form.getGlobalContext().Core.getPatientShort() , domain.getPIDDiagnosisInfo(form.getGlobalContext().Core.getCurrentCareContext(), form.getGlobalContext().Core.getEpisodeofCareShort()));
	}


	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				newAlert();					
				break;
			case GenForm.ContextMenus.GenericGrid.Update:
				editAlert();
				break;
		}
		
	}

	@Override
	protected void onChkNoKnownAllergiesValueChanged() throws PresentationLogicException 
	{
		if(form.ctnDetails().chkNoKnownAlerts().getValue())
		{
			clearCurScreen();
			form.ctnDetails().setCollapsed(false);
			enableDetailsControls(false);
			form.ctnDetails().customControlAuthoringInfo().initializeComponent();
			//WDEV-12901 
			Object mos = domain.getMosUser();
			if(mos != null){
				form.ctnDetails().cmbRecordingHCP().newRow((MemberOfStaffLiteVo)mos, ((MemberOfStaffLiteVo)mos).getIMosName());
				form.ctnDetails().cmbRecordingHCP().setValue((MemberOfStaffLiteVo)mos);
			}
			form.ctnDetails().dtimRecordingDateTime().setValue(new DateTime());
		}		
		else
		{
			enableDetailsControls(true);
		}
		
	}

	private void enableDetailsControls(boolean bEnable)
	{
		form.ctnDetails().cmbCategory().setEnabled(bEnable);
		form.ctnDetails().cmbAlerts().setEnabled(bEnable);
		form.ctnDetails().cmbAlerts().setEnabled(bEnable);
		form.ctnDetails().txtComment().setEnabled(bEnable);

		if (form.getMode().equals(FormMode.EDIT) && form.ctnDetails().chkNoKnownAlerts().getValue())
		{
			form.ctnDetails().cmbSource().setRequired(false);
			bEnable = true;
		}
		else
			form.ctnDetails().cmbSource().setRequired(true);
		
		form.ctnDetails().cmbSource().setEnabled(bEnable);
		form.ctnDetails().pdtIdentified().setEnabled(bEnable);
		form.ctnDetails().setcustomControlAuthoringInfoEnabled(bEnable);
		form.ctnDetails().setCollapsed(false);
		
	}

	//	WDEV-14413
	@Override
	protected void onBtnCloseClick() throws PresentationLogicException 
	{
		if(!isAlertForTriage())
			return;
		
		engine.close(DialogResult.CANCEL);
	}

	//WDEV-14413
	private boolean isAlertForTriage() 
	{
		if(form.getForms().Core.AlertsForTriage.equals(engine.getFormName()))
			return true;
		
		return false;
	}

	//	WDEV-14413
	@Override
	protected void onFormModeChanged() 
	{
		updateControlsState();
	}

	//	WDEV-14413
	private void updateControlsState() 
	{
		form.btnClose().setVisible(isAlertForTriage() && FormMode.VIEW.equals(form.getMode()));//WDEV-14413
		form.btnClose().setEnabled(isAlertForTriage() && FormMode.VIEW.equals(form.getMode()));//WDEV-14413
	}

	@Override
	protected void onRIEDialogClosed(DialogResult result) throws PresentationLogicException
	{
		PatientAlert voPatientAlert = form.getLocalContext().getAlertRecord();

		LookupInstVo inst = LookupHelper.getAlertTypeInstance(domain.getLookupService(), voPatientAlert.getAlertType().getID());
		LookupInstVo alertMappings = domain.getMappings(inst);

		if (alertMappings != null)
		{
			for ( int i = 0 ; i < alertMappings.getMappings().size() ; i++)
			{
				if (alertMappings.getMappings().get(i).getExtSystem() != null
					&& alertMappings.getMappings().get(i).getExtSystem().equals("PAS"))
				{
					try
					{
						domain.saveHeartsAlert(voPatientAlert.getPatient(), alertMappings.getMappings().get(i).getExtCode().toString(), Boolean.FALSE);
					}
					catch (DomainInterfaceException e)
					{
						e.printStackTrace();
					}
					catch (StaleObjectException e)
					{
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	@Override
	protected void onCmbAlertsValueChanged() throws PresentationLogicException
	{
		alertsValueChanged();
	}
	
	private void alertsValueChanged()
	{
		if( ! ConfigFlag.UI.BED_INFO_UI_TYPE.getValue().equals("WST"))
			return;

		form.ctnDetails().cmbSource().setEnabled(form.getMode().equals(FormMode.EDIT) ? true : false);

		defaultSourceCombo();
	}
	private void defaultSourceCombo()
	{

		if (form.getMode().equals(FormMode.EDIT))
		{
			if (form.ctnDetails().cmbSource().getValue() != null
					&& form.ctnDetails().cmbSource().getValue().equals(SourceofInformation.PAS))
				form.ctnDetails().cmbSource().setValue(null);

			if (form.ctnDetails().cmbAlerts().getValue() != null)
			{
				LookupInstVo inst = LookupHelper.getAlertTypeInstance(domain.getLookupService(), form.ctnDetails().cmbAlerts().getValue().getID());
				LookupInstVo alertMappings = domain.getMappings(inst);

				if (alertMappings != null)
				{
					for ( int i = 0 ; i < alertMappings.getMappings().size() ; i++)
					{
						if (alertMappings.getMappings().get(i).getExtSystem() != null
							&& alertMappings.getMappings().get(i).getExtSystem().equals("PAS"))
						{
							form.ctnDetails().cmbSource().setEnabled(false);
							form.ctnDetails().cmbSource().setValue(SourceofInformation.PAS);
						}
					}
				}
			}
		}
	}

}
