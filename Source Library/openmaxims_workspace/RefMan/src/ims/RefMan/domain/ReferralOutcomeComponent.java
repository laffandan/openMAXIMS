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

package ims.RefMan.domain;

// Generated from form domain impl
public interface ReferralOutcomeComponent extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listHotlistProcedureShort
	*/
	public ims.core.vo.ProcedureLiteVoCollection listHotlistProcedureShort(String procedureName, ims.core.vo.lookups.Specialty specialty) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.ServiceShortVo getCatsReferralService(ims.RefMan.vo.CatsReferralRefVo voCatsReferralRef);

	// Generated from form domain interface definition
	/**
	* save
	*/
	public ims.RefMan.vo.ReferralOutcomeVo saveReferralOutcome(ims.RefMan.vo.ReferralOutcomeVo voReferralOutcome) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Get
	*/
	public ims.RefMan.vo.ReferralOutcomeVo getReferralOutcome(ims.RefMan.vo.CatsReferralRefVo voCATSRef);

	// Generated from form domain interface definition
	public ims.core.vo.OrgLiteVoCollection listAllSuppliers();

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralWizardVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo voCatsRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralWizardVo saveCatsReferral(ims.RefMan.vo.CatsReferralWizardVo record) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.MedicationVo createOrUpdateMedication(ims.core.vo.MedicationVo value) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* updateReferralOutcome
	*/
	public ims.RefMan.vo.CatsReferralWizardVo updateReferralOutcome(ims.RefMan.vo.CatsReferralWizardVo record) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;

	// Generated from form domain interface definition
	/**
	* getCatsReferralStatus
	*/
	public ims.RefMan.vo.CatsReferralStatusLiteVo getCatsReferralStatus(ims.RefMan.vo.CatsReferralRefVo catsRefVo);

	// Generated from form domain interface definition
	/**
	* getOutcome
	*/
	public ims.RefMan.vo.ReferralOutcomeVo getOutcome(ims.RefMan.vo.ReferralOutcomeRefVo outcome);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralReportsVo getCatsReferralReports(ims.RefMan.vo.CatsReferralRefVo voCatsRef);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralReportsVo saveCatsReferralReport(ims.RefMan.vo.CatsReferralReportsVo recvord) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.ocrr.vo.OrderInvestigationListVoCollection getInvestigation(ims.RefMan.vo.CatsReferralRefVo referral);

	// Generated from form domain interface definition
	public ims.core.vo.PatientDiagnosisLiteVoCollection getDiagnosis(ims.RefMan.vo.CatsReferralRefVo referral);
}
