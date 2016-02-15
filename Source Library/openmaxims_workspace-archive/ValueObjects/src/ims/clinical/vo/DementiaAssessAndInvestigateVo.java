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

package ims.clinical.vo;

/**
 * Linked to core.clinical.DementiaAssessAndInvestigate business object (ID: 1003100119).
 */
public class DementiaAssessAndInvestigateVo extends ims.core.clinical.vo.DementiaAssessAndInvestigateRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DementiaAssessAndInvestigateVo()
	{
	}
	public DementiaAssessAndInvestigateVo(Integer id, int version)
	{
		super(id, version);
	}
	public DementiaAssessAndInvestigateVo(ims.clinical.vo.beans.DementiaAssessAndInvestigateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.q1age = bean.getQ1Age() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ1Age());
		this.q2dob = bean.getQ2DOB() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ2DOB());
		this.q3currentyear = bean.getQ3CurrentYear() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ3CurrentYear());
		this.q4currenttime = bean.getQ4CurrentTime() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ4CurrentTime());
		this.q5nameofhospital = bean.getQ5NameOfHospital() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ5NameOfHospital());
		this.q6recognisepeople = bean.getQ6RecognisePeople() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ6RecognisePeople());
		this.q7yearww2ended = bean.getQ7YearWW2Ended() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ7YearWW2Ended());
		this.q8monarch = bean.getQ8Monarch() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ8Monarch());
		this.q9countbackwards = bean.getQ9CountBackwards() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ9CountBackwards());
		this.q10recall = bean.getQ10Recall() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ10Recall());
		this.amtsscore = bean.getAMTSScore();
		this.confirmtrustsprotocol = bean.getConfirmTrustsProtocol() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getConfirmTrustsProtocol());
		this.confirmmedicationreview = bean.getConfirmMedicationReview() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getConfirmMedicationReview());
		this.steptwoassessnote = bean.getStepTwoAssessNote() == null ? null : bean.getStepTwoAssessNote().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.DementiaAssessAndInvestigateVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.q1age = bean.getQ1Age() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ1Age());
		this.q2dob = bean.getQ2DOB() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ2DOB());
		this.q3currentyear = bean.getQ3CurrentYear() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ3CurrentYear());
		this.q4currenttime = bean.getQ4CurrentTime() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ4CurrentTime());
		this.q5nameofhospital = bean.getQ5NameOfHospital() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ5NameOfHospital());
		this.q6recognisepeople = bean.getQ6RecognisePeople() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ6RecognisePeople());
		this.q7yearww2ended = bean.getQ7YearWW2Ended() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ7YearWW2Ended());
		this.q8monarch = bean.getQ8Monarch() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ8Monarch());
		this.q9countbackwards = bean.getQ9CountBackwards() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ9CountBackwards());
		this.q10recall = bean.getQ10Recall() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getQ10Recall());
		this.amtsscore = bean.getAMTSScore();
		this.confirmtrustsprotocol = bean.getConfirmTrustsProtocol() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getConfirmTrustsProtocol());
		this.confirmmedicationreview = bean.getConfirmMedicationReview() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getConfirmMedicationReview());
		this.steptwoassessnote = bean.getStepTwoAssessNote() == null ? null : bean.getStepTwoAssessNote().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.DementiaAssessAndInvestigateVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.DementiaAssessAndInvestigateVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.DementiaAssessAndInvestigateVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("Q1AGE"))
			return getQ1Age();
		if(fieldName.equals("Q2DOB"))
			return getQ2DOB();
		if(fieldName.equals("Q3CURRENTYEAR"))
			return getQ3CurrentYear();
		if(fieldName.equals("Q4CURRENTTIME"))
			return getQ4CurrentTime();
		if(fieldName.equals("Q5NAMEOFHOSPITAL"))
			return getQ5NameOfHospital();
		if(fieldName.equals("Q6RECOGNISEPEOPLE"))
			return getQ6RecognisePeople();
		if(fieldName.equals("Q7YEARWW2ENDED"))
			return getQ7YearWW2Ended();
		if(fieldName.equals("Q8MONARCH"))
			return getQ8Monarch();
		if(fieldName.equals("Q9COUNTBACKWARDS"))
			return getQ9CountBackwards();
		if(fieldName.equals("Q10RECALL"))
			return getQ10Recall();
		if(fieldName.equals("AMTSSCORE"))
			return getAMTSScore();
		if(fieldName.equals("CONFIRMTRUSTSPROTOCOL"))
			return getConfirmTrustsProtocol();
		if(fieldName.equals("CONFIRMMEDICATIONREVIEW"))
			return getConfirmMedicationReview();
		if(fieldName.equals("STEPTWOASSESSNOTE"))
			return getStepTwoAssessNote();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getQ1AgeIsNotNull()
	{
		return this.q1age != null;
	}
	public ims.core.vo.lookups.YesNo getQ1Age()
	{
		return this.q1age;
	}
	public void setQ1Age(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.q1age = value;
	}
	public boolean getQ2DOBIsNotNull()
	{
		return this.q2dob != null;
	}
	public ims.core.vo.lookups.YesNo getQ2DOB()
	{
		return this.q2dob;
	}
	public void setQ2DOB(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.q2dob = value;
	}
	public boolean getQ3CurrentYearIsNotNull()
	{
		return this.q3currentyear != null;
	}
	public ims.core.vo.lookups.YesNo getQ3CurrentYear()
	{
		return this.q3currentyear;
	}
	public void setQ3CurrentYear(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.q3currentyear = value;
	}
	public boolean getQ4CurrentTimeIsNotNull()
	{
		return this.q4currenttime != null;
	}
	public ims.core.vo.lookups.YesNo getQ4CurrentTime()
	{
		return this.q4currenttime;
	}
	public void setQ4CurrentTime(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.q4currenttime = value;
	}
	public boolean getQ5NameOfHospitalIsNotNull()
	{
		return this.q5nameofhospital != null;
	}
	public ims.core.vo.lookups.YesNo getQ5NameOfHospital()
	{
		return this.q5nameofhospital;
	}
	public void setQ5NameOfHospital(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.q5nameofhospital = value;
	}
	public boolean getQ6RecognisePeopleIsNotNull()
	{
		return this.q6recognisepeople != null;
	}
	public ims.core.vo.lookups.YesNo getQ6RecognisePeople()
	{
		return this.q6recognisepeople;
	}
	public void setQ6RecognisePeople(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.q6recognisepeople = value;
	}
	public boolean getQ7YearWW2EndedIsNotNull()
	{
		return this.q7yearww2ended != null;
	}
	public ims.core.vo.lookups.YesNo getQ7YearWW2Ended()
	{
		return this.q7yearww2ended;
	}
	public void setQ7YearWW2Ended(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.q7yearww2ended = value;
	}
	public boolean getQ8MonarchIsNotNull()
	{
		return this.q8monarch != null;
	}
	public ims.core.vo.lookups.YesNo getQ8Monarch()
	{
		return this.q8monarch;
	}
	public void setQ8Monarch(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.q8monarch = value;
	}
	public boolean getQ9CountBackwardsIsNotNull()
	{
		return this.q9countbackwards != null;
	}
	public ims.core.vo.lookups.YesNo getQ9CountBackwards()
	{
		return this.q9countbackwards;
	}
	public void setQ9CountBackwards(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.q9countbackwards = value;
	}
	public boolean getQ10RecallIsNotNull()
	{
		return this.q10recall != null;
	}
	public ims.core.vo.lookups.YesNo getQ10Recall()
	{
		return this.q10recall;
	}
	public void setQ10Recall(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.q10recall = value;
	}
	public boolean getAMTSScoreIsNotNull()
	{
		return this.amtsscore != null;
	}
	public Integer getAMTSScore()
	{
		return this.amtsscore;
	}
	public void setAMTSScore(Integer value)
	{
		this.isValidated = false;
		this.amtsscore = value;
	}
	public boolean getConfirmTrustsProtocolIsNotNull()
	{
		return this.confirmtrustsprotocol != null;
	}
	public ims.core.vo.lookups.YesNo getConfirmTrustsProtocol()
	{
		return this.confirmtrustsprotocol;
	}
	public void setConfirmTrustsProtocol(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.confirmtrustsprotocol = value;
	}
	public boolean getConfirmMedicationReviewIsNotNull()
	{
		return this.confirmmedicationreview != null;
	}
	public ims.core.vo.lookups.YesNo getConfirmMedicationReview()
	{
		return this.confirmmedicationreview;
	}
	public void setConfirmMedicationReview(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.confirmmedicationreview = value;
	}
	public boolean getStepTwoAssessNoteIsNotNull()
	{
		return this.steptwoassessnote != null;
	}
	public ims.clinical.vo.DementiaAssessInvestigateNoteVo getStepTwoAssessNote()
	{
		return this.steptwoassessnote;
	}
	public void setStepTwoAssessNote(ims.clinical.vo.DementiaAssessInvestigateNoteVo value)
	{
		this.isValidated = false;
		this.steptwoassessnote = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.steptwoassessnote != null)
		{
			if(!this.steptwoassessnote.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.q1age == null)
			listOfErrors.add("Q1Age is mandatory");
		if(this.q2dob == null)
			listOfErrors.add("Q2DOB is mandatory");
		if(this.q3currentyear == null)
			listOfErrors.add("Q3CurrentYear is mandatory");
		if(this.q4currenttime == null)
			listOfErrors.add("Q4CurrentTime is mandatory");
		if(this.q5nameofhospital == null)
			listOfErrors.add("Q5NameOfHospital is mandatory");
		if(this.q6recognisepeople == null)
			listOfErrors.add("Q6RecognisePeople is mandatory");
		if(this.q7yearww2ended == null)
			listOfErrors.add("Q7YearWW2Ended is mandatory");
		if(this.q8monarch == null)
			listOfErrors.add("Q8Monarch is mandatory");
		if(this.q9countbackwards == null)
			listOfErrors.add("Q9CountBackwards is mandatory");
		if(this.q10recall == null)
			listOfErrors.add("Q10Recall is mandatory");
		if(this.steptwoassessnote != null)
		{
			String[] listOfOtherErrors = this.steptwoassessnote.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		DementiaAssessAndInvestigateVo clone = new DementiaAssessAndInvestigateVo(this.id, this.version);
		
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.q1age == null)
			clone.q1age = null;
		else
			clone.q1age = (ims.core.vo.lookups.YesNo)this.q1age.clone();
		if(this.q2dob == null)
			clone.q2dob = null;
		else
			clone.q2dob = (ims.core.vo.lookups.YesNo)this.q2dob.clone();
		if(this.q3currentyear == null)
			clone.q3currentyear = null;
		else
			clone.q3currentyear = (ims.core.vo.lookups.YesNo)this.q3currentyear.clone();
		if(this.q4currenttime == null)
			clone.q4currenttime = null;
		else
			clone.q4currenttime = (ims.core.vo.lookups.YesNo)this.q4currenttime.clone();
		if(this.q5nameofhospital == null)
			clone.q5nameofhospital = null;
		else
			clone.q5nameofhospital = (ims.core.vo.lookups.YesNo)this.q5nameofhospital.clone();
		if(this.q6recognisepeople == null)
			clone.q6recognisepeople = null;
		else
			clone.q6recognisepeople = (ims.core.vo.lookups.YesNo)this.q6recognisepeople.clone();
		if(this.q7yearww2ended == null)
			clone.q7yearww2ended = null;
		else
			clone.q7yearww2ended = (ims.core.vo.lookups.YesNo)this.q7yearww2ended.clone();
		if(this.q8monarch == null)
			clone.q8monarch = null;
		else
			clone.q8monarch = (ims.core.vo.lookups.YesNo)this.q8monarch.clone();
		if(this.q9countbackwards == null)
			clone.q9countbackwards = null;
		else
			clone.q9countbackwards = (ims.core.vo.lookups.YesNo)this.q9countbackwards.clone();
		if(this.q10recall == null)
			clone.q10recall = null;
		else
			clone.q10recall = (ims.core.vo.lookups.YesNo)this.q10recall.clone();
		clone.amtsscore = this.amtsscore;
		if(this.confirmtrustsprotocol == null)
			clone.confirmtrustsprotocol = null;
		else
			clone.confirmtrustsprotocol = (ims.core.vo.lookups.YesNo)this.confirmtrustsprotocol.clone();
		if(this.confirmmedicationreview == null)
			clone.confirmmedicationreview = null;
		else
			clone.confirmmedicationreview = (ims.core.vo.lookups.YesNo)this.confirmmedicationreview.clone();
		if(this.steptwoassessnote == null)
			clone.steptwoassessnote = null;
		else
			clone.steptwoassessnote = (ims.clinical.vo.DementiaAssessInvestigateNoteVo)this.steptwoassessnote.clone();
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
		if (!(DementiaAssessAndInvestigateVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DementiaAssessAndInvestigateVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DementiaAssessAndInvestigateVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DementiaAssessAndInvestigateVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.authoringinformation != null)
			count++;
		if(this.q1age != null)
			count++;
		if(this.q2dob != null)
			count++;
		if(this.q3currentyear != null)
			count++;
		if(this.q4currenttime != null)
			count++;
		if(this.q5nameofhospital != null)
			count++;
		if(this.q6recognisepeople != null)
			count++;
		if(this.q7yearww2ended != null)
			count++;
		if(this.q8monarch != null)
			count++;
		if(this.q9countbackwards != null)
			count++;
		if(this.q10recall != null)
			count++;
		if(this.amtsscore != null)
			count++;
		if(this.confirmtrustsprotocol != null)
			count++;
		if(this.confirmmedicationreview != null)
			count++;
		if(this.steptwoassessnote != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 15;
	}
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.vo.lookups.YesNo q1age;
	protected ims.core.vo.lookups.YesNo q2dob;
	protected ims.core.vo.lookups.YesNo q3currentyear;
	protected ims.core.vo.lookups.YesNo q4currenttime;
	protected ims.core.vo.lookups.YesNo q5nameofhospital;
	protected ims.core.vo.lookups.YesNo q6recognisepeople;
	protected ims.core.vo.lookups.YesNo q7yearww2ended;
	protected ims.core.vo.lookups.YesNo q8monarch;
	protected ims.core.vo.lookups.YesNo q9countbackwards;
	protected ims.core.vo.lookups.YesNo q10recall;
	protected Integer amtsscore;
	protected ims.core.vo.lookups.YesNo confirmtrustsprotocol;
	protected ims.core.vo.lookups.YesNo confirmmedicationreview;
	protected ims.clinical.vo.DementiaAssessInvestigateNoteVo steptwoassessnote;
	private boolean isValidated = false;
	private boolean isBusy = false;
}