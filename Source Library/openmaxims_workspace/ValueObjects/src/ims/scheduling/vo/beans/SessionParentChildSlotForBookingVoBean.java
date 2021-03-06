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

package ims.scheduling.vo.beans;

public class SessionParentChildSlotForBookingVoBean extends ims.vo.ValueObjectBean
{
	public SessionParentChildSlotForBookingVoBean()
	{
	}
	public SessionParentChildSlotForBookingVoBean(ims.scheduling.vo.SessionParentChildSlotForBookingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.starttime = vo.getStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTime().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionIntermediateVoBean)vo.getSession().getBean();
		this.duration = vo.getDuration();
		if(vo.getChildSlots() != null)
		{
			this.childslots = new ims.vo.RefVoBean[vo.getChildSlots().size()];
			for(int childslots_i = 0; childslots_i < vo.getChildSlots().size(); childslots_i++)
			{
				this.childslots[childslots_i] = new ims.vo.RefVoBean(vo.getChildSlots().get(childslots_i).getBoId(),vo.getChildSlots().get(childslots_i).getBoVersion());
			}
		}
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.SessionParentChildSlotForBookingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.starttime = vo.getStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTime().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionIntermediateVoBean)vo.getSession().getBean(map);
		this.duration = vo.getDuration();
		if(vo.getChildSlots() != null)
		{
			this.childslots = new ims.vo.RefVoBean[vo.getChildSlots().size()];
			for(int childslots_i = 0; childslots_i < vo.getChildSlots().size(); childslots_i++)
			{
				this.childslots[childslots_i] = new ims.vo.RefVoBean(vo.getChildSlots().get(childslots_i).getBoId(),vo.getChildSlots().get(childslots_i).getBoVersion());
			}
		}
	}

	public ims.scheduling.vo.SessionParentChildSlotForBookingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.SessionParentChildSlotForBookingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.SessionParentChildSlotForBookingVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.SessionParentChildSlotForBookingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.SessionParentChildSlotForBookingVo();
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
	public ims.framework.utils.beans.TimeBean getStartTime()
	{
		return this.starttime;
	}
	public void setStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.starttime = value;
	}
	public ims.scheduling.vo.beans.SessionIntermediateVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.beans.SessionIntermediateVoBean value)
	{
		this.session = value;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.duration = value;
	}
	public ims.vo.RefVoBean[] getChildSlots()
	{
		return this.childslots;
	}
	public void setChildSlots(ims.vo.RefVoBean[] value)
	{
		this.childslots = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.TimeBean starttime;
	private ims.scheduling.vo.beans.SessionIntermediateVoBean session;
	private Integer duration;
	private ims.vo.RefVoBean[] childslots;
}
