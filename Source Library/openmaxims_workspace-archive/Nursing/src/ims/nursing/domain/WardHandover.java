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

package ims.nursing.domain;

// Generated from form domain impl
public interface WardHandover extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* List all clinical notes records with Hospital Report attribute marked for a time period
	*/
	public ims.coe.vo.HospitalReportCollection listHospitalReports(ims.core.vo.LocMostVo voWard, ims.framework.utils.DateTime fromDateTime, ims.framework.utils.DateTime toDateTime, Boolean hospitalReport, Boolean isCorrected);

	// Generated from form domain interface definition
	/**
	* list locations
	*/
	public ims.core.vo.LocMostVoCollection listLocations(ims.core.vo.LocMostVo locationFilterVo);

	// Generated from form domain interface definition
	/**
	* getReportAndTemplate
	*/
	public String[] getReportAndTemplate(Integer nReportId, Integer nTemplateId) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	/**
	* getPatientFromClinicalContact
	*/
	public ims.core.vo.PatientShort getPatientFromCareContext(ims.core.admin.vo.CareContextRefVo clinContactRefVo);

	// Generated from form domain interface definition
	public ims.core.vo.CareContextVo getCareContext(ims.core.admin.vo.CareContextRefVo clinicalContactRefVo);
}