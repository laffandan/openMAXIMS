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

package ims.scheduling.vo.beans;

public class BookingAppointmentClinicListListVoBean extends ims.vo.ValueObjectBean
{
	public BookingAppointmentClinicListListVoBean()
	{
	}
	public BookingAppointmentClinicListListVoBean(ims.scheduling.vo.BookingAppointmentClinicListListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityLiteVoBean)vo.getActivity().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientClinicListListVoBean)vo.getPatient().getBean();
		this.iscabbooking = vo.getIsCABBooking();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionClinicListListVoBean)vo.getSession().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.BookingAppointmentClinicListListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.apptstatus = vo.getApptStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getApptStatus().getBean();
		this.activity = vo.getActivity() == null ? null : (ims.core.vo.beans.ActivityLiteVoBean)vo.getActivity().getBean(map);
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientClinicListListVoBean)vo.getPatient().getBean(map);
		this.iscabbooking = vo.getIsCABBooking();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionClinicListListVoBean)vo.getSession().getBean(map);
	}

	public ims.scheduling.vo.BookingAppointmentClinicListListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.BookingAppointmentClinicListListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.BookingAppointmentClinicListListVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.BookingAppointmentClinicListListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.BookingAppointmentClinicListListVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.framework.utils.beans.DateBean getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.beans.DateBean value)
	{
		this.appointmentdate = value;
	}
	public ims.framework.utils.beans.TimeBean getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptstarttime = value;
	}
	public ims.vo.LookupInstanceBean getApptStatus()
	{
		return this.apptstatus;
	}
	public void setApptStatus(ims.vo.LookupInstanceBean value)
	{
		this.apptstatus = value;
	}
	public ims.core.vo.beans.ActivityLiteVoBean getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.core.vo.beans.ActivityLiteVoBean value)
	{
		this.activity = value;
	}
	public ims.core.vo.beans.PatientClinicListListVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientClinicListListVoBean value)
	{
		this.patient = value;
	}
	public Boolean getIsCABBooking()
	{
		return this.iscabbooking;
	}
	public void setIsCABBooking(Boolean value)
	{
		this.iscabbooking = value;
	}
	public ims.scheduling.vo.beans.SessionClinicListListVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.beans.SessionClinicListListVoBean value)
	{
		this.session = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean appointmentdate;
	private ims.framework.utils.beans.TimeBean apptstarttime;
	private ims.vo.LookupInstanceBean apptstatus;
	private ims.core.vo.beans.ActivityLiteVoBean activity;
	private ims.core.vo.beans.PatientClinicListListVoBean patient;
	private Boolean iscabbooking;
	private ims.scheduling.vo.beans.SessionClinicListListVoBean session;
}
