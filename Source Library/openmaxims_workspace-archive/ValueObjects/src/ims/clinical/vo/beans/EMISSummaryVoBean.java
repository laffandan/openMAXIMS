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

package ims.clinical.vo.beans;

public class EMISSummaryVoBean extends ims.vo.ValueObjectBean
{
	public EMISSummaryVoBean()
	{
	}
	public EMISSummaryVoBean(ims.clinical.vo.EMISSummaryVo vo)
	{
		this.currentgppractice = vo.getCurrentGPPractice();
		this.problems = vo.getProblems() == null ? null : vo.getProblems().getBeanCollection();
		this.medications = vo.getMedications() == null ? null : vo.getMedications().getBeanCollection();
		this.allergies = vo.getAllergies() == null ? null : vo.getAllergies().getBeanCollection();
		this.alerts = vo.getAlerts() == null ? null : vo.getAlerts().getBeanCollection();
		this.diaries = vo.getDiaries() == null ? null : vo.getDiaries().getBeanCollection();
		this.lastconsultations = vo.getLastConsultations() == null ? null : vo.getLastConsultations().getBeanCollection();
		this.healthstatus = vo.getHealthStatus() == null ? null : vo.getHealthStatus().getBeanCollection();
		this.acute = vo.getAcute() == null ? null : vo.getAcute().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.EMISSummaryVo vo)
	{
		this.currentgppractice = vo.getCurrentGPPractice();
		this.problems = vo.getProblems() == null ? null : vo.getProblems().getBeanCollection();
		this.medications = vo.getMedications() == null ? null : vo.getMedications().getBeanCollection();
		this.allergies = vo.getAllergies() == null ? null : vo.getAllergies().getBeanCollection();
		this.alerts = vo.getAlerts() == null ? null : vo.getAlerts().getBeanCollection();
		this.diaries = vo.getDiaries() == null ? null : vo.getDiaries().getBeanCollection();
		this.lastconsultations = vo.getLastConsultations() == null ? null : vo.getLastConsultations().getBeanCollection();
		this.healthstatus = vo.getHealthStatus() == null ? null : vo.getHealthStatus().getBeanCollection();
		this.acute = vo.getAcute() == null ? null : vo.getAcute().getBeanCollection();
	}

	public ims.clinical.vo.EMISSummaryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.EMISSummaryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.EMISSummaryVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.EMISSummaryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.EMISSummaryVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getCurrentGPPractice()
	{
		return this.currentgppractice;
	}
	public void setCurrentGPPractice(String value)
	{
		this.currentgppractice = value;
	}
	public ims.clinical.vo.beans.EMISObservationVoBean[] getProblems()
	{
		return this.problems;
	}
	public void setProblems(ims.clinical.vo.beans.EMISObservationVoBean[] value)
	{
		this.problems = value;
	}
	public ims.clinical.vo.beans.EMISMedicationVoBean[] getMedications()
	{
		return this.medications;
	}
	public void setMedications(ims.clinical.vo.beans.EMISMedicationVoBean[] value)
	{
		this.medications = value;
	}
	public ims.clinical.vo.beans.EMISAllergiesVoBean[] getAllergies()
	{
		return this.allergies;
	}
	public void setAllergies(ims.clinical.vo.beans.EMISAllergiesVoBean[] value)
	{
		this.allergies = value;
	}
	public ims.clinical.vo.beans.EMISAlertsVoBean[] getAlerts()
	{
		return this.alerts;
	}
	public void setAlerts(ims.clinical.vo.beans.EMISAlertsVoBean[] value)
	{
		this.alerts = value;
	}
	public ims.clinical.vo.beans.EMISDiariesVoBean[] getDiaries()
	{
		return this.diaries;
	}
	public void setDiaries(ims.clinical.vo.beans.EMISDiariesVoBean[] value)
	{
		this.diaries = value;
	}
	public ims.clinical.vo.beans.EMISLastConsultationsVoBean[] getLastConsultations()
	{
		return this.lastconsultations;
	}
	public void setLastConsultations(ims.clinical.vo.beans.EMISLastConsultationsVoBean[] value)
	{
		this.lastconsultations = value;
	}
	public ims.clinical.vo.beans.EMISHealthStatusVoBean[] getHealthStatus()
	{
		return this.healthstatus;
	}
	public void setHealthStatus(ims.clinical.vo.beans.EMISHealthStatusVoBean[] value)
	{
		this.healthstatus = value;
	}
	public ims.clinical.vo.beans.EMISAcuteVoBean[] getAcute()
	{
		return this.acute;
	}
	public void setAcute(ims.clinical.vo.beans.EMISAcuteVoBean[] value)
	{
		this.acute = value;
	}

	private String currentgppractice;
	private ims.clinical.vo.beans.EMISObservationVoBean[] problems;
	private ims.clinical.vo.beans.EMISMedicationVoBean[] medications;
	private ims.clinical.vo.beans.EMISAllergiesVoBean[] allergies;
	private ims.clinical.vo.beans.EMISAlertsVoBean[] alerts;
	private ims.clinical.vo.beans.EMISDiariesVoBean[] diaries;
	private ims.clinical.vo.beans.EMISLastConsultationsVoBean[] lastconsultations;
	private ims.clinical.vo.beans.EMISHealthStatusVoBean[] healthstatus;
	private ims.clinical.vo.beans.EMISAcuteVoBean[] acute;
}