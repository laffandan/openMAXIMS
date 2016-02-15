// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.appointmentpatientdiagnosisdialog;

import ims.RefMan.vo.CSPrimaryDiagnosisForClinicalNotesVo;
import ims.RefMan.vo.CSPrimaryDiagnosisForClinicalNotesVoCollection;
import ims.RefMan.vo.PatientDiagnosisApptDetailVo;
import ims.clinical.vo.lookups.CodingItemType;
import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			engine.close(DialogResult.OK);
	}

	private boolean save()
	{
		PatientDiagnosisApptDetailVo diagnosis = populateDataFromScreen();
		
		String[] errors = diagnosis.validate();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
	
		try
		{
			form.getGlobalContext().RefMan.setAppointmentPatientDiagnosis(domain.savePatientDiagnosis(diagnosis));
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			engine.close(DialogResult.ABORT);
			return false;
		}
		
		return true;
	}

	private PatientDiagnosisApptDetailVo populateDataFromScreen()
	{
		PatientDiagnosisApptDetailVo diagnosis = form.getGlobalContext().RefMan.getAppointmentPatientDiagnosis();	
		setCsPrimaryDiagnosis(diagnosis, form.chkMain().getValue());
		
		return diagnosis;
	}
	
	private void setCsPrimaryDiagnosis(PatientDiagnosisApptDetailVo voPatDiagnosis, boolean isChkPrimaryChecked)
	{
		CSPrimaryDiagnosisForClinicalNotesVo voCSPrimaryDiagnosis = getPrimaryDiagnosisRecord(voPatDiagnosis);
		
		if (voCSPrimaryDiagnosis != null || isChkPrimaryChecked)
		{
			if (voCSPrimaryDiagnosis == null)
			{
				voCSPrimaryDiagnosis = populatePrimaryDiagnosisDataFromScreen(new CSPrimaryDiagnosisForClinicalNotesVo(), voPatDiagnosis, isChkPrimaryChecked);
				
				if (voPatDiagnosis.getPrimaryForCareSpells() == null)
					voPatDiagnosis.setPrimaryForCareSpells(new CSPrimaryDiagnosisForClinicalNotesVoCollection());
				
				voPatDiagnosis.getPrimaryForCareSpells().add(voCSPrimaryDiagnosis);
			}
			else
			{
				int index = voPatDiagnosis.getPrimaryForCareSpells().indexOf(voCSPrimaryDiagnosis);
				if (index >= 0)
				{
					voCSPrimaryDiagnosis = populatePrimaryDiagnosisDataFromScreen(voCSPrimaryDiagnosis, voPatDiagnosis, isChkPrimaryChecked);
					voPatDiagnosis.getPrimaryForCareSpells().set(index, voCSPrimaryDiagnosis);
				}
			}
		}
	}
	
	private CSPrimaryDiagnosisForClinicalNotesVo populatePrimaryDiagnosisDataFromScreen(CSPrimaryDiagnosisForClinicalNotesVo primaryDiagnosisVo, PatientDiagnosisApptDetailVo voPatDiagnosis, boolean isChkPrimaryChecked)
	{
		if (primaryDiagnosisVo == null)
			primaryDiagnosisVo = new CSPrimaryDiagnosisForClinicalNotesVo();
		
		primaryDiagnosisVo.setAuthoringInformation(form.ccAuthoring().getValue());
		primaryDiagnosisVo.setDiagnosis(voPatDiagnosis);
		primaryDiagnosisVo.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		if(primaryDiagnosisVo.getEpisodeOfCare() == null)
			primaryDiagnosisVo.setEpisodeOfCare(form.getGlobalContext().Core.getEpisodeofCareShort());
		
		primaryDiagnosisVo.setIsActive(isChkPrimaryChecked);
		
		return primaryDiagnosisVo;
	}
	
	private CSPrimaryDiagnosisForClinicalNotesVo getPrimaryDiagnosisRecord(PatientDiagnosisApptDetailVo voPatDiagnosis)
	{
		if (voPatDiagnosis == null || voPatDiagnosis.getPrimaryForCareSpells() == null)
			return null;

		CSPrimaryDiagnosisForClinicalNotesVoCollection voColl = voPatDiagnosis.getPrimaryForCareSpells();
		for (int i = 0; voColl != null && i < voColl.size(); i++)
		{
			boolean sameDiagnosis = voColl.get(i).getDiagnosisIsNotNull() && voColl.get(i).getDiagnosis().equals(voPatDiagnosis);
			boolean sameCareContext = voColl.get(i).getCareContextIsNotNull() && voColl.get(i).getCareContext().equals(form.getGlobalContext().Core.getCurrentCareContext());

			if (sameDiagnosis && sameCareContext && voColl.get(i).getIsActiveIsNotNull() && voColl.get(i).getIsActive())
				return voColl.get(i);
		}

		return null;
	}

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		initialize();
		open();
	}

	private void initialize()
	{
		form.ccDiagnosis().setCodingItemType(CodingItemType.DIAGNOSIS);
		form.ccDiagnosis().setIsRequired(true);
		form.ccDiagnosis().setParentEditing(true);
		
		form.ccDiagnosis().setEnabled(false);
	}

	private void open()
	{
		populateScreenFromData(form.getGlobalContext().RefMan.getAppointmentPatientDiagnosis());
	}

	private void populateScreenFromData(PatientDiagnosisApptDetailVo patientDiagnosis)
	{
		if(patientDiagnosis == null)
			return;
		
		form.ccDiagnosis().setValue(patientDiagnosis);
		form.ccAuthoring().setValue(patientDiagnosis.getAuthoringInfo());
		
		CSPrimaryDiagnosisForClinicalNotesVo primDiag= getPrimaryDiagnosisRecord(patientDiagnosis);
		form.chkMain().setValue(primDiag != null && Boolean.TRUE.equals(primDiag.getIsActive()));
	}
}