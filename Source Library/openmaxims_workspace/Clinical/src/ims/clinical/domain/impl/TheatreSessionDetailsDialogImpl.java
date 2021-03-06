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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.80 build 5465.13953)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.clinical.domain.base.impl.BaseTheatreSessionDetailsDialogImpl;
import ims.clinical.domain.objects.TheatreSessionStaffDetail;
import ims.clinical.vo.domain.TheatreSessionStaffDetailVoAssembler;
import ims.core.vo.domain.NurseLiteVoAssembler;
import ims.core.vo.lookups.HcpDisType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class TheatreSessionDetailsDialogImpl extends BaseTheatreSessionDetailsDialogImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* getTheatreSessionStaffDetails
	*/
	public ims.clinical.vo.TheatreSessionStaffDetailVo getTheatreSessionStaffDetails(ims.scheduling.vo.Sch_SessionRefVo session)
	{
		if (session == null)
			throw new CodingRuntimeException("session is null in method getTheatreSessionStaffDetails");

		return TheatreSessionStaffDetailVoAssembler.create(TheatreSessionStaffDetail.getTheatreSessionStaffDetailFromTheatreSession(getDomainFactory(), session.getID_Sch_Session()));
	}

	/**
	* saveTheatreSessionStaffDetail
	*/
	public void saveTheatreSessionStaffDetail(ims.clinical.vo.TheatreSessionStaffDetailVo theatreSessionStaffDetail) throws ims.domain.exceptions.StaleObjectException,DomainInterfaceException
	{
		String methodName = "saveTheatreSessionStaffDetail";
		if (theatreSessionStaffDetail == null)
			throw new CodingRuntimeException("theatreSessionStaffDetail is null in method " + methodName);
		if (!theatreSessionStaffDetail.isValidated())
			throw new CodingRuntimeException("theatreSessionStaffDetail has not been validated in method " + methodName);

		DomainFactory factory = getDomainFactory();
		TheatreSessionStaffDetail doTheatreStaffDetail = TheatreSessionStaffDetailVoAssembler.extractTheatreSessionStaffDetail(factory, theatreSessionStaffDetail);
		//WDEV-21778
		try
		{			
			factory.save(doTheatreStaffDetail);
		}
		catch(UnqViolationUncheckedException ex)
		{
			throw new DomainInterfaceException(ex);
		}
	}

	/**
	* listMedicListVo
	*/
	public ims.core.vo.MedicLiteVoCollection listMedicLiteVo(String name)
	{
		HcpAdmin impl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return impl.listActiveMedics(name);
	}

	/**
	* listNurseLiteVo
	*/
	public ims.core.vo.NurseLiteVoCollection listNurseLiteVo(String name)
	{
		DomainFactory factory = getDomainFactory();
		List nurses = factory.find("select nurseAlias from Nurse as nurseAlias left join nurseAlias.mos as mosAlias " +
				"where nurseAlias.hcpType.id =:idHcpDisType and nurseAlias.isActive = 1 and mosAlias.name.upperSurname like :nurseName", 
				new String[] {"idHcpDisType","nurseName"}, new Object[] {HcpDisType.NURSING.getID(), "%" + name.toUpperCase() + "%"});
		//TODO maybe use HcpDisType.CirculatingNurse?
		
		return NurseLiteVoAssembler.createNurseLiteVoCollectionFromNurse(nurses);
	}
}
