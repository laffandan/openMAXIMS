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

package ims.RefMan.vo;


public class RTTManagementGridValueVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RTTManagementGridValueVo()
	{
	}
	public RTTManagementGridValueVo(ims.RefMan.vo.beans.RTTManagementGridValueVoBean bean)
	{
		this.clockimpactref = bean.getClockImpactRef() == null ? null : new ims.pathways.vo.PathwaysRTTClockImpactRefVo(new Integer(bean.getClockImpactRef().getId()), bean.getClockImpactRef().getVersion());
		this.rttstatus = bean.getRttStatus() == null ? null : new ims.pathways.vo.PathwayRTTStatusRefVo(new Integer(bean.getRttStatus().getId()), bean.getRttStatus().getVersion());
		this.ishistoric = bean.getIsHistoric();
		this.clock = bean.getClock() == null ? null : new ims.pathways.vo.PathwayClockRefVo(new Integer(bean.getClock().getId()), bean.getClock().getVersion());
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.statusdt = bean.getStatusDT() == null ? null : bean.getStatusDT().buildDateTime();
		this.clockimpactsource = bean.getClockImpactSource() == null ? null : ims.pathways.vo.lookups.RTTClockImpactSource.buildLookup(bean.getClockImpactSource());
		this.firstrttstatus = bean.getFirstRTTStatus();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.RTTManagementGridValueVoBean bean)
	{
		this.clockimpactref = bean.getClockImpactRef() == null ? null : new ims.pathways.vo.PathwaysRTTClockImpactRefVo(new Integer(bean.getClockImpactRef().getId()), bean.getClockImpactRef().getVersion());
		this.rttstatus = bean.getRttStatus() == null ? null : new ims.pathways.vo.PathwayRTTStatusRefVo(new Integer(bean.getRttStatus().getId()), bean.getRttStatus().getVersion());
		this.ishistoric = bean.getIsHistoric();
		this.clock = bean.getClock() == null ? null : new ims.pathways.vo.PathwayClockRefVo(new Integer(bean.getClock().getId()), bean.getClock().getVersion());
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.statusdt = bean.getStatusDT() == null ? null : bean.getStatusDT().buildDateTime();
		this.clockimpactsource = bean.getClockImpactSource() == null ? null : ims.pathways.vo.lookups.RTTClockImpactSource.buildLookup(bean.getClockImpactSource());
		this.firstrttstatus = bean.getFirstRTTStatus();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.RTTManagementGridValueVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.RTTManagementGridValueVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.RTTManagementGridValueVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getClockImpactRefIsNotNull()
	{
		return this.clockimpactref != null;
	}
	public ims.pathways.vo.PathwaysRTTClockImpactRefVo getClockImpactRef()
	{
		return this.clockimpactref;
	}
	public void setClockImpactRef(ims.pathways.vo.PathwaysRTTClockImpactRefVo value)
	{
		this.isValidated = false;
		this.clockimpactref = value;
	}
	public boolean getRttStatusIsNotNull()
	{
		return this.rttstatus != null;
	}
	public ims.pathways.vo.PathwayRTTStatusRefVo getRttStatus()
	{
		return this.rttstatus;
	}
	public void setRttStatus(ims.pathways.vo.PathwayRTTStatusRefVo value)
	{
		this.isValidated = false;
		this.rttstatus = value;
	}
	public boolean getIsHistoricIsNotNull()
	{
		return this.ishistoric != null;
	}
	public Boolean getIsHistoric()
	{
		return this.ishistoric;
	}
	public void setIsHistoric(Boolean value)
	{
		this.isValidated = false;
		this.ishistoric = value;
	}
	public boolean getClockIsNotNull()
	{
		return this.clock != null;
	}
	public ims.pathways.vo.PathwayClockRefVo getClock()
	{
		return this.clock;
	}
	public void setClock(ims.pathways.vo.PathwayClockRefVo value)
	{
		this.isValidated = false;
		this.clock = value;
	}
	public boolean getCatsReferralIsNotNull()
	{
		return this.catsreferral != null;
	}
	public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.RefMan.vo.CatsReferralRefVo value)
	{
		this.isValidated = false;
		this.catsreferral = value;
	}
	public boolean getStatusDTIsNotNull()
	{
		return this.statusdt != null;
	}
	public ims.framework.utils.DateTime getStatusDT()
	{
		return this.statusdt;
	}
	public void setStatusDT(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.statusdt = value;
	}
	public boolean getClockImpactSourceIsNotNull()
	{
		return this.clockimpactsource != null;
	}
	public ims.pathways.vo.lookups.RTTClockImpactSource getClockImpactSource()
	{
		return this.clockimpactsource;
	}
	public void setClockImpactSource(ims.pathways.vo.lookups.RTTClockImpactSource value)
	{
		this.isValidated = false;
		this.clockimpactsource = value;
	}
	public boolean getFirstRTTStatusIsNotNull()
	{
		return this.firstrttstatus != null;
	}
	public Boolean getFirstRTTStatus()
	{
		return this.firstrttstatus;
	}
	public void setFirstRTTStatus(Boolean value)
	{
		this.isValidated = false;
		this.firstrttstatus = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof RTTManagementGridValueVo))
			return false;
		RTTManagementGridValueVo compareObj = (RTTManagementGridValueVo)obj;
		if(this.getClockImpactRef() == null && compareObj.getClockImpactRef() != null)
			return false;
		if(this.getClockImpactRef() != null && compareObj.getClockImpactRef() == null)
			return false;
		if(this.getClockImpactRef() != null && compareObj.getClockImpactRef() != null)
			if(!this.getClockImpactRef().equals(compareObj.getClockImpactRef()))
				return false;
		if(this.getRttStatus() == null && compareObj.getRttStatus() != null)
			return false;
		if(this.getRttStatus() != null && compareObj.getRttStatus() == null)
			return false;
		if(this.getRttStatus() != null && compareObj.getRttStatus() != null)
			return this.getRttStatus().equals(compareObj.getRttStatus());
		return super.equals(obj);
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		RTTManagementGridValueVo clone = new RTTManagementGridValueVo();
		
		clone.clockimpactref = this.clockimpactref;
		clone.rttstatus = this.rttstatus;
		clone.ishistoric = this.ishistoric;
		clone.clock = this.clock;
		clone.catsreferral = this.catsreferral;
		if(this.statusdt == null)
			clone.statusdt = null;
		else
			clone.statusdt = (ims.framework.utils.DateTime)this.statusdt.clone();
		if(this.clockimpactsource == null)
			clone.clockimpactsource = null;
		else
			clone.clockimpactsource = (ims.pathways.vo.lookups.RTTClockImpactSource)this.clockimpactsource.clone();
		clone.firstrttstatus = this.firstrttstatus;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(RTTManagementGridValueVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RTTManagementGridValueVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		RTTManagementGridValueVo compareObj = (RTTManagementGridValueVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getClockImpactRef() == null && compareObj.getClockImpactRef() != null)
				return -1;
			if(this.getClockImpactRef() != null && compareObj.getClockImpactRef() == null)
				return 1;
			if(this.getClockImpactRef() != null && compareObj.getClockImpactRef() != null)
				retVal = this.getClockImpactRef().compareTo(compareObj.getClockImpactRef());
		}
		if (retVal == 0)
		{
			if(this.getRttStatus() == null && compareObj.getRttStatus() != null)
				return -1;
			if(this.getRttStatus() != null && compareObj.getRttStatus() == null)
				return 1;
			if(this.getRttStatus() != null && compareObj.getRttStatus() != null)
				retVal = this.getRttStatus().compareTo(compareObj.getRttStatus());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.clockimpactref != null)
			count++;
		if(this.rttstatus != null)
			count++;
		if(this.ishistoric != null)
			count++;
		if(this.clock != null)
			count++;
		if(this.catsreferral != null)
			count++;
		if(this.statusdt != null)
			count++;
		if(this.clockimpactsource != null)
			count++;
		if(this.firstrttstatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.pathways.vo.PathwaysRTTClockImpactRefVo clockimpactref;
	protected ims.pathways.vo.PathwayRTTStatusRefVo rttstatus;
	protected Boolean ishistoric;
	protected ims.pathways.vo.PathwayClockRefVo clock;
	protected ims.RefMan.vo.CatsReferralRefVo catsreferral;
	protected ims.framework.utils.DateTime statusdt;
	protected ims.pathways.vo.lookups.RTTClockImpactSource clockimpactsource;
	protected Boolean firstrttstatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
