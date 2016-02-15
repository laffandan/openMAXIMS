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
// This code was generated by Florin Blindu using IMS Development Environment (version 1.80 build 5256.13787)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import java.util.Date;
import java.util.List;

import ims.RefMan.domain.base.impl.BaseLinkAppointmentsImpl;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.core.admin.domain.objects.CareContext;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Time;
import ims.scheduling.vo.domain.BookingAppointmentForLinkedAppointmentsVoAssembler;
import ims.scheduling.vo.lookups.Status_Reason;

public class LinkAppointmentsImpl extends BaseLinkAppointmentsImpl
{

	private static final long serialVersionUID = 1L;

	public ims.scheduling.vo.BookingAppointmentForLinkedAppointmentsVoCollection listAppointments(ims.core.admin.vo.CareContextRefVo careContextRef)
	{
		if(careContextRef == null || careContextRef.getID_CareContext() == null)
			throw new CodingRuntimeException("Cannnot return Booking_Appointments for a null CareContextID.");
		
		
		String query = "select appt from Booking_Appointment as appt where ( appt.careContext.id = :careContextID and appt.apptStatus.id = :statusID and ((appt.appointmentDate > :apptDate) or (appt.appointmentDate = :apptDate and appt.apptStartTime > :apptTime)) and appt.theatreBooking = null)";
		DomainFactory factory = getDomainFactory();
		
		List<?> list = factory.find(query, new String[] {"careContextID","statusID","apptDate","apptTime"}, new Object[] {careContextRef.getID_CareContext(), Status_Reason.BOOKED.getID(), new Date(), new Time().toString()});
		
		return BookingAppointmentForLinkedAppointmentsVoAssembler.createBookingAppointmentForLinkedAppointmentsVoCollectionFromBooking_Appointment(list);
	}

	public CareContextShortVo getCareContextByCatsRef(CatsReferralRefVo catsReferralRef)
	{
		if(catsReferralRef == null || catsReferralRef.getID_CatsReferral() == null)
			throw new CodingRuntimeException("Cannnot return CareContext for a null CatsReferral.");
		
		String query = "select catsRef.careContext from CatsReferral as catsRef  where catsRef.id = :catsRefID ";
		DomainFactory factory = getDomainFactory();
		
		List<?> list = factory.find(query, new String[] {"catsRefID"}, new Object[] {catsReferralRef.getID_CatsReferral()});
		
		if (list==null || list.size()==0)
			return null;
		
		return CareContextShortVoAssembler.create((CareContext) list.get(0));
	}
}