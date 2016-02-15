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

package ims.emergency.vo.beans;

public class TriageProtocolAssessmentShortVoBean extends ims.vo.ValueObjectBean
{
	public TriageProtocolAssessmentShortVoBean()
	{
	}
	public TriageProtocolAssessmentShortVoBean(ims.emergency.vo.TriageProtocolAssessmentShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.triagepriority = vo.getTriagePriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getTriagePriority().getBean();
		this.triageprotocol = vo.getTriageProtocol() == null ? null : (ims.emergency.vo.beans.ManchesterTriageProtocolConfigLiteVoBean)vo.getTriageProtocol().getBean();
		this.patientproblem = vo.getPatientProblem() == null ? null : (ims.emergency.vo.beans.PatientProblemForTrackingVoBean)vo.getPatientProblem().getBean();
		this.ismain = vo.getIsMain();
		this.discriminator = vo.getDiscriminator() == null ? null : (ims.emergency.vo.beans.ProtocolDiscriminatorLiteVoBean)vo.getDiscriminator().getBean();
		this.assessmentdatetime = vo.getAssessmentDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAssessmentDateTime().getBean();
		this.assessmentnurse = vo.getAssessmentNurse() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAssessmentNurse().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TriageProtocolAssessmentShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.triagepriority = vo.getTriagePriority() == null ? null : (ims.vo.LookupInstanceBean)vo.getTriagePriority().getBean();
		this.triageprotocol = vo.getTriageProtocol() == null ? null : (ims.emergency.vo.beans.ManchesterTriageProtocolConfigLiteVoBean)vo.getTriageProtocol().getBean(map);
		this.patientproblem = vo.getPatientProblem() == null ? null : (ims.emergency.vo.beans.PatientProblemForTrackingVoBean)vo.getPatientProblem().getBean(map);
		this.ismain = vo.getIsMain();
		this.discriminator = vo.getDiscriminator() == null ? null : (ims.emergency.vo.beans.ProtocolDiscriminatorLiteVoBean)vo.getDiscriminator().getBean(map);
		this.assessmentdatetime = vo.getAssessmentDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAssessmentDateTime().getBean();
		this.assessmentnurse = vo.getAssessmentNurse() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getAssessmentNurse().getBean(map);
	}

	public ims.emergency.vo.TriageProtocolAssessmentShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TriageProtocolAssessmentShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TriageProtocolAssessmentShortVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TriageProtocolAssessmentShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TriageProtocolAssessmentShortVo();
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
	public ims.vo.LookupInstanceBean getTriagePriority()
	{
		return this.triagepriority;
	}
	public void setTriagePriority(ims.vo.LookupInstanceBean value)
	{
		this.triagepriority = value;
	}
	public ims.emergency.vo.beans.ManchesterTriageProtocolConfigLiteVoBean getTriageProtocol()
	{
		return this.triageprotocol;
	}
	public void setTriageProtocol(ims.emergency.vo.beans.ManchesterTriageProtocolConfigLiteVoBean value)
	{
		this.triageprotocol = value;
	}
	public ims.emergency.vo.beans.PatientProblemForTrackingVoBean getPatientProblem()
	{
		return this.patientproblem;
	}
	public void setPatientProblem(ims.emergency.vo.beans.PatientProblemForTrackingVoBean value)
	{
		this.patientproblem = value;
	}
	public Boolean getIsMain()
	{
		return this.ismain;
	}
	public void setIsMain(Boolean value)
	{
		this.ismain = value;
	}
	public ims.emergency.vo.beans.ProtocolDiscriminatorLiteVoBean getDiscriminator()
	{
		return this.discriminator;
	}
	public void setDiscriminator(ims.emergency.vo.beans.ProtocolDiscriminatorLiteVoBean value)
	{
		this.discriminator = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAssessmentDateTime()
	{
		return this.assessmentdatetime;
	}
	public void setAssessmentDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.assessmentdatetime = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getAssessmentNurse()
	{
		return this.assessmentnurse;
	}
	public void setAssessmentNurse(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.assessmentnurse = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean triagepriority;
	private ims.emergency.vo.beans.ManchesterTriageProtocolConfigLiteVoBean triageprotocol;
	private ims.emergency.vo.beans.PatientProblemForTrackingVoBean patientproblem;
	private Boolean ismain;
	private ims.emergency.vo.beans.ProtocolDiscriminatorLiteVoBean discriminator;
	private ims.framework.utils.beans.DateTimeBean assessmentdatetime;
	private ims.core.vo.beans.HcpLiteVoBean assessmentnurse;
}