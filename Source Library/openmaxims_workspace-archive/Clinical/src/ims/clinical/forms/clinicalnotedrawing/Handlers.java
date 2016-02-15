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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.forms.clinicalnotedrawing;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbDisciplineLookup();
	abstract protected void defaultcmbDisciplineLookupValue();
	abstract protected void bindcmbDisciplineOPLookup();
	abstract protected void defaultcmbDisciplineOPLookupValue();
	abstract protected void bindcmbFollowUpLookup();
	abstract protected void defaultcmbFollowUpLookupValue();
	abstract protected void bindcmbReviewLookup();
	abstract protected void defaultcmbReviewLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onRIEDialogClosed(ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onlyrTabsTabChanged(ims.framework.LayerBridge tab);
	abstract protected void onBtnNewNotingClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateNotingClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveNotingClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelNotingClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbDisciplineValueSet(Object value);
	abstract protected void onChkMarkAsReviewedValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkForReviewValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCNCloseClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDtimTransByIPValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateSOAPClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewSOAPClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelSOAPClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveSOAPClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkObjectiveProblemClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkSubjectiveProblemClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkAnalysisDiagnosisClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkSurgeryClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbDisciplineOPValueSet(Object value);
	abstract protected void onChkForReviewOPValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkMarkAsReviewedOPValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnOPCloseClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkOPManagementMedicationClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkOPProblemClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkOPDiagnosisClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onLnkOPSurgeryClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbFollowUpValueSet(Object value);
	abstract protected void onCmbFollowUpValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveOPNotesClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelOPNotesClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateOPNotesClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewOPClinicalNoteClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbReviewValueSet(Object value);
	abstract protected void onImbURLClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onCmbGraphicAdnotationImageValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnUpdateGraphicClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnNewGraphicClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelGraphicClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnSaveGraphicClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onDyngrdAssessmentsCellButtonClicked(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdAssessmentsCellValueChanged(ims.framework.controls.DynamicGridCell cell);
	abstract protected void onDyngrdAssessmentsRowSelectionChanged(ims.framework.controls.DynamicGridRow row) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setRIEDialogClosedEvent(new RIEDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onRIEDialogClosed(result);
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen();
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.lyrTabs().tabDetails().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTabstabDetailsActivated();
			}
		});
		this.form.lyrTabs().tabClinicalNotes().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTabstabClinicalNotesActivated();
			}
		});
		this.form.lyrTabs().tabOPDNote().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTabstabOPDNoteActivated();
			}
		});
		this.form.lyrTabs().tabDrawing().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTabstabDrawingActivated();
			}
		});
		this.form.lyrTabs().tabAssessment().setTabActivatedEvent(new ims.framework.delegates.TabActivated()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onlyrTabstabAssessmentActivated();
			}
		});
		this.form.lyrTabs().tabDetails().btnNewNoting().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewNotingClick();
			}
		});
		this.form.lyrTabs().tabDetails().btnUpdateNoting().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateNotingClick();
			}
		});
		this.form.lyrTabs().tabDetails().btnSaveNoting().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveNotingClick();
			}
		});
		this.form.lyrTabs().tabDetails().btnCancelNoting().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelNotingClick();
			}
		});
		this.form.lyrTabs().tabClinicalNotes().cmbDiscipline().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDisciplineValueSet(value);
			}
		});
		this.form.lyrTabs().tabClinicalNotes().chkMarkAsReviewed().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkMarkAsReviewedValueChanged();
			}
		});
		this.form.lyrTabs().tabClinicalNotes().chkForReview().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkForReviewValueChanged();
			}
		});
		this.form.lyrTabs().tabClinicalNotes().btnCNClose().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCNCloseClick();
			}
		});
		this.form.lyrTabs().tabClinicalNotes().dtimTransByIP().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onDtimTransByIPValueChanged();
			}
		});
		this.form.lyrTabs().tabClinicalNotes().btnUpdateSOAP().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateSOAPClick();
			}
		});
		this.form.lyrTabs().tabClinicalNotes().btnNewSOAP().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewSOAPClick();
			}
		});
		this.form.lyrTabs().tabClinicalNotes().btnCancelSOAP().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelSOAPClick();
			}
		});
		this.form.lyrTabs().tabClinicalNotes().btnSaveSOAP().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveSOAPClick();
			}
		});
		this.form.lyrTabs().tabClinicalNotes().lnkObjectiveProblem().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkObjectiveProblemClick();
			}
		});
		this.form.lyrTabs().tabClinicalNotes().lnkSubjectiveProblem().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkSubjectiveProblemClick();
			}
		});
		this.form.lyrTabs().tabClinicalNotes().lnkAnalysisDiagnosis().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkAnalysisDiagnosisClick();
			}
		});
		this.form.lyrTabs().tabClinicalNotes().lnkSurgery().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkSurgeryClick();
			}
		});
		this.form.lyrTabs().tabOPDNote().cmbDisciplineOP().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbDisciplineOPValueSet(value);
			}
		});
		this.form.lyrTabs().tabOPDNote().chkForReviewOP().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkForReviewOPValueChanged();
			}
		});
		this.form.lyrTabs().tabOPDNote().chkMarkAsReviewedOP().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkMarkAsReviewedOPValueChanged();
			}
		});
		this.form.lyrTabs().tabOPDNote().btnOPClose().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnOPCloseClick();
			}
		});
		this.form.lyrTabs().tabOPDNote().lnkOPManagementMedication().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkOPManagementMedicationClick();
			}
		});
		this.form.lyrTabs().tabOPDNote().lnkOPProblem().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkOPProblemClick();
			}
		});
		this.form.lyrTabs().tabOPDNote().lnkOPDiagnosis().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkOPDiagnosisClick();
			}
		});
		this.form.lyrTabs().tabOPDNote().lnkOPSurgery().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onLnkOPSurgeryClick();
			}
		});
		this.form.lyrTabs().tabOPDNote().cmbFollowUp().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbFollowUpValueSet(value);
			}
		});
		this.form.lyrTabs().tabOPDNote().cmbFollowUp().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbFollowUpValueChanged();
			}
		});
		this.form.lyrTabs().tabOPDNote().btnSaveOPNotes().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveOPNotesClick();
			}
		});
		this.form.lyrTabs().tabOPDNote().btnCancelOPNotes().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelOPNotesClick();
			}
		});
		this.form.lyrTabs().tabOPDNote().btnUpdateOPNotes().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateOPNotesClick();
			}
		});
		this.form.lyrTabs().tabOPDNote().btnNewOPClinicalNote().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewOPClinicalNoteClick();
			}
		});
		this.form.lyrTabs().tabOPDNote().cmbReview().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbReviewValueSet(value);
			}
		});
		this.form.lyrTabs().tabDrawing().imbURL().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbURLClick();
			}
		});
		this.form.lyrTabs().tabDrawing().cmbGraphicAdnotationImage().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbGraphicAdnotationImageValueChanged();
			}
		});
		this.form.lyrTabs().tabDrawing().btnUpdateGraphic().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnUpdateGraphicClick();
			}
		});
		this.form.lyrTabs().tabDrawing().btnNewGraphic().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnNewGraphicClick();
			}
		});
		this.form.lyrTabs().tabDrawing().btnCancelGraphic().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelGraphicClick();
			}
		});
		this.form.lyrTabs().tabDrawing().btnSaveGraphic().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnSaveGraphicClick();
			}
		});
		this.form.lyrTabs().tabAssessment().dyngrdAssessments().setDynamicGridCellButtonClickedEvent(new DynamicGridCellButtonClicked()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdAssessmentsCellButtonClicked(cell);
			}
		});
		this.form.lyrTabs().tabAssessment().dyngrdAssessments().setDynamicGridCellValueChangedEvent(new DynamicGridCellValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridCell cell) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdAssessmentsCellValueChanged(cell);
			}
		});
		this.form.lyrTabs().tabAssessment().dyngrdAssessments().setDynamicGridRowSelectionChangedEvent(new DynamicGridRowSelectionChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.controls.DynamicGridRow row, ims.framework.enumerations.MouseButton mouseButton) throws ims.framework.exceptions.PresentationLogicException
			{
				onDyngrdAssessmentsRowSelectionChanged(row);
			}
		});
		this.form.getContextMenus().getPatientAssessmentAddItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatientAssessment.Add, sender);
			}
		});
		this.form.getContextMenus().getPatientAssessmentUpdateItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatientAssessment.Update, sender);
			}
		});
		this.form.getContextMenus().getPatientAssessmentAddGraphicAssessmentItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatientAssessment.AddGraphicAssessment, sender);
			}
		});
		this.form.getContextMenus().getPatientAssessmentUpdateGraphicAssessmentItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatientAssessment.UpdateGraphicAssessment, sender);
			}
		});
		this.form.getContextMenus().getPatientAssessmentViewGraphicAssessmentItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatientAssessment.ViewGraphicAssessment, sender);
			}
		});
		this.form.getContextMenus().getPatientAssessmentAddUserAssessmentItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatientAssessment.AddUserAssessment, sender);
			}
		});
		this.form.getContextMenus().getPatientAssessmentUpdateUserAssessmentItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatientAssessment.UpdateUserAssessment, sender);
			}
		});
		this.form.getContextMenus().getPatientAssessmentViewUserAssessmentItem().setClickEvent(new ims.framework.delegates.MenuItemClick()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
			{
				onContextMenuItemClick(GenForm.ContextMenus.PatientAssessment.ViewUserAssessment, sender);
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbDisciplineLookup();
		bindcmbDisciplineOPLookup();
		bindcmbFollowUpLookup();
		bindcmbReviewLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbDisciplineLookup();
		bindcmbDisciplineOPLookup();
		bindcmbFollowUpLookup();
		bindcmbReviewLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbDisciplineLookupValue();
		defaultcmbDisciplineOPLookupValue();
		defaultcmbFollowUpLookupValue();
		defaultcmbReviewLookupValue();
	}
	private void onlyrTabstabDetailsActivated()
	{
		this.form.lyrTabs().showtabDetails();
		onlyrTabsTabChanged(this.form.lyrTabs().tabDetails());
	}
	private void onlyrTabstabClinicalNotesActivated()
	{
		this.form.lyrTabs().showtabClinicalNotes();
		onlyrTabsTabChanged(this.form.lyrTabs().tabClinicalNotes());
	}
	private void onlyrTabstabOPDNoteActivated()
	{
		this.form.lyrTabs().showtabOPDNote();
		onlyrTabsTabChanged(this.form.lyrTabs().tabOPDNote());
	}
	private void onlyrTabstabDrawingActivated()
	{
		this.form.lyrTabs().showtabDrawing();
		onlyrTabsTabChanged(this.form.lyrTabs().tabDrawing());
	}
	private void onlyrTabstabAssessmentActivated()
	{
		this.form.lyrTabs().showtabAssessment();
		onlyrTabsTabChanged(this.form.lyrTabs().tabAssessment());
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}