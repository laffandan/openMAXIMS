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

package ims.core.vo;

/**
 * Linked to core.patient.Patient business object (ID: 1001100000).
 */
public class PatientLite_IdentifiersVo extends ims.core.vo.PatientLiteVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IPendingAdmission, ims.vo.interfaces.IPendingAdmissionDetails
{
	private static final long serialVersionUID = 1L;

	public PatientLite_IdentifiersVo()
	{
	}
	public PatientLite_IdentifiersVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientLite_IdentifiersVo(ims.core.vo.beans.PatientLite_IdentifiersVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo();
		this.sex = bean.getSex() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getSex());
		this.dob = bean.getDob() == null ? null : bean.getDob().buildPartialDate();
		this.isactive = bean.getIsActive();
		this.isquickregistrationpatient = bean.getIsQuickRegistrationPatient();
		this.primaryidvalueused = bean.getPrimaryIdValueUsed();
		this.identifiers = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getIdentifiers());
		this.dod = bean.getDod() == null ? null : bean.getDod().buildDate();
		this.age = bean.getAge();
		this.agetext = bean.getAgeText();
		this.patientcategory = bean.getPatientCategory() == null ? null : ims.core.vo.lookups.PatientStatus.buildLookup(bean.getPatientCategory());
		if(bean.getPatientAlerts() != null)
		{
			this.patientalerts = new ims.core.clinical.vo.PatientAlertRefVoCollection();
			for(int patientalerts_i = 0; patientalerts_i < bean.getPatientAlerts().length; patientalerts_i++)
			{
				this.patientalerts.add(new ims.core.clinical.vo.PatientAlertRefVo(new Integer(bean.getPatientAlerts()[patientalerts_i].getId()), bean.getPatientAlerts()[patientalerts_i].getVersion()));
			}
		}
		this.hasalerts = bean.getHasAlerts();
		this.associatedpatient = bean.getAssociatedPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getAssociatedPatient().getId()), bean.getAssociatedPatient().getVersion());
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo();
		this.isselfadmitpatient = bean.getIsSelfAdmitPatient();
		this.timeofdeath = bean.getTimeOfDeath() == null ? null : bean.getTimeOfDeath().buildTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientLite_IdentifiersVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo(map);
		this.sex = bean.getSex() == null ? null : ims.core.vo.lookups.Sex.buildLookup(bean.getSex());
		this.dob = bean.getDob() == null ? null : bean.getDob().buildPartialDate();
		this.isactive = bean.getIsActive();
		this.isquickregistrationpatient = bean.getIsQuickRegistrationPatient();
		this.primaryidvalueused = bean.getPrimaryIdValueUsed();
		this.identifiers = ims.core.vo.PatientIdCollection.buildFromBeanCollection(bean.getIdentifiers());
		this.dod = bean.getDod() == null ? null : bean.getDod().buildDate();
		this.age = bean.getAge();
		this.agetext = bean.getAgeText();
		this.patientcategory = bean.getPatientCategory() == null ? null : ims.core.vo.lookups.PatientStatus.buildLookup(bean.getPatientCategory());
		if(bean.getPatientAlerts() != null)
		{
			this.patientalerts = new ims.core.clinical.vo.PatientAlertRefVoCollection();
			for(int patientalerts_i = 0; patientalerts_i < bean.getPatientAlerts().length; patientalerts_i++)
			{
				this.patientalerts.add(new ims.core.clinical.vo.PatientAlertRefVo(new Integer(bean.getPatientAlerts()[patientalerts_i].getId()), bean.getPatientAlerts()[patientalerts_i].getVersion()));
			}
		}
		this.hasalerts = bean.getHasAlerts();
		this.associatedpatient = bean.getAssociatedPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getAssociatedPatient().getId()), bean.getAssociatedPatient().getVersion());
		this.ward = bean.getWard() == null ? null : bean.getWard().buildVo(map);
		this.isselfadmitpatient = bean.getIsSelfAdmitPatient();
		this.timeofdeath = bean.getTimeOfDeath() == null ? null : bean.getTimeOfDeath().buildTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientLite_IdentifiersVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientLite_IdentifiersVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientLite_IdentifiersVoBean();
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
		if(fieldName.equals("PATIENTCATEGORY"))
			return getPatientCategory();
		if(fieldName.equals("PATIENTALERTS"))
			return getPatientAlerts();
		if(fieldName.equals("HASALERTS"))
			return getHasAlerts();
		if(fieldName.equals("ASSOCIATEDPATIENT"))
			return getAssociatedPatient();
		if(fieldName.equals("WARD"))
			return getWard();
		if(fieldName.equals("ISSELFADMITPATIENT"))
			return getIsSelfAdmitPatient();
		if(fieldName.equals("TIMEOFDEATH"))
			return getTimeOfDeath();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientCategoryIsNotNull()
	{
		return this.patientcategory != null;
	}
	public ims.core.vo.lookups.PatientStatus getPatientCategory()
	{
		return this.patientcategory;
	}
	public void setPatientCategory(ims.core.vo.lookups.PatientStatus value)
	{
		this.isValidated = false;
		this.patientcategory = value;
	}
	public boolean getPatientAlertsIsNotNull()
	{
		return this.patientalerts != null;
	}
	public ims.core.clinical.vo.PatientAlertRefVoCollection getPatientAlerts()
	{
		return this.patientalerts;
	}
	public void setPatientAlerts(ims.core.clinical.vo.PatientAlertRefVoCollection value)
	{
		this.isValidated = false;
		this.patientalerts = value;
	}
	public boolean getHasAlertsIsNotNull()
	{
		return this.hasalerts != null;
	}
	public Boolean getHasAlerts()
	{
		return this.hasalerts;
	}
	public void setHasAlerts(Boolean value)
	{
		this.isValidated = false;
		this.hasalerts = value;
	}
	public boolean getAssociatedPatientIsNotNull()
	{
		return this.associatedpatient != null;
	}
	public ims.core.patient.vo.PatientRefVo getAssociatedPatient()
	{
		return this.associatedpatient;
	}
	public void setAssociatedPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.associatedpatient = value;
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.vo.LocationLiteVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getIsSelfAdmitPatientIsNotNull()
	{
		return this.isselfadmitpatient != null;
	}
	public Boolean getIsSelfAdmitPatient()
	{
		return this.isselfadmitpatient;
	}
	public void setIsSelfAdmitPatient(Boolean value)
	{
		this.isValidated = false;
		this.isselfadmitpatient = value;
	}
	public boolean getTimeOfDeathIsNotNull()
	{
		return this.timeofdeath != null;
	}
	public ims.framework.utils.Time getTimeOfDeath()
	{
		return this.timeofdeath;
	}
	public void setTimeOfDeath(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.timeofdeath = value;
	}
	/**
	* getDisplayId() - Gets the default identifier as specified by the ConfigFlag.UI.DEFAULT_PATIENT_ID_TYPE
	*/
	public ims.core.vo.PatientId getDisplayId()
	{
		String name = ims.configuration.ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue();
		ims.core.vo.lookups.PatIdType type = ims.core.vo.lookups.PatIdType.getNegativeInstance(name);
		
		if (type == null) type = ims.core.vo.lookups.PatIdType.HOSPNUM;
		return getPatId(type);
	}
	/**
	* getPatId() - Gets the patient identifier for the type passed in
	*/
	public ims.core.vo.PatientId getPatId(ims.core.vo.lookups.PatIdType idType)
	{
		if (identifiers == null) return null;
		for (int i = 0; i < identifiers.size(); i++)
		{
			ims.core.vo.PatientId id = identifiers.get(i);
			if (id.getType().equals(idType))
			{
				return id;
			}
		}
		return null;
	}
	/**
	* calculateAge
	*/
	public Integer calculateAge()
	{
		calculateAgeText();
		if (dob != null)
		{		
			int patAge = 0;
			if (dod != null)
			{
				patAge = dod.yearDiff(dob);
			}
			else
			{
				patAge = new ims.framework.utils.Age(this.dob, this.dod).getYears();
			}
			setAge(new Integer(patAge));
		}
		return getAge();
	}
	/**
	* getNHS
	*/
	public ims.core.vo.PatientId getNHS()
	{
		return getPatId(ims.core.vo.lookups.PatIdType.NHSN);
	}
	/**
	* calculateAgeText
	*/
	public String calculateAgeText()
	{
		agetext = "-";
		if (dob != null)
		{
			if (ims.configuration.ConfigFlag.UI.HAS_PAEDIATRIC_PATIENTS.getValue())
				agetext = new ims.framework.utils.Age(this.dob, this.dod).toPaediatricString();
			else
				agetext = new ims.framework.utils.Age(this.dob, this.dod).toString();			
		}
		return getAgeText();
	}
	/**
	* IPendingAdmission implementation
	*/
	public String getPatientSurname()
	{
		if (this.name != null)
			return this.name.surname;
	
		return null;
	}
	
	public String getPatientForename()
	{
		if (this.name != null)
			return this.name.forename;
	
		return null;
	}
	
	public PatientId getPatientDisplayIdentifier()
	{
		return this.getDisplayId();
	}
	
	public ims.core.vo.lookups.Sex getPatientSex()
	{
		return this.sex;
	}
	
	public Integer getPatientAge()
	{
		return this.calculateAge();
	}
	
	public ims.framework.utils.PartialDate getPatientDoB()
	{
		return this.getDob();
	}
	
	public String getLengthOfStay()
	{
		return null;
	}
	
	public ims.framework.utils.DateTime getTCIDateTime()
	{
		return null;
	}
	
	public Boolean hasTCIComments()
	{
		return null;
	}
	
	public ims.framework.utils.Time getWardAttendanceAppointmentTime()
	{
		return null;
	}
	
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this;
	}
	
	public ims.framework.utils.Date getPatientDod()
	{
		return this.dod;
	}
	
	public ims.core.patient.vo.PatientRefVo getPatientAssociatedPatient()
	{
		return this.associatedpatient;
	}
	
	public ims.framework.utils.Time getPatientTimeOfDeath()
	{
		return this.timeofdeath;
	}
	
	public String getPatientAgeText()
	{
		return this.calculateAgeText();
	}
	
	public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
	{
		return null;
	}
	/**
	* IPendingAdmissionDetails implementation
	*/
	public ServiceLiteVo getPendingAdmissionService()
	{
		return null;
	}
	
	public ims.core.vo.lookups.Specialty getPendingAdmissionSpecialty()
	{
		return null;
	}
	
	public MemberOfStaffLiteVo getPendingAdmissionConsultant()
	{
		return null;
	}
	
	public ims.core.vo.lookups.MethodOfAdmission getPendingAdmissionMethodOfAdmission()
	{
		return ims.core.vo.lookups.MethodOfAdmission.EMERGENCY;
	}
	
	public ims.core.vo.lookups.PatientStatus getPendingAdmissionPatientCategory()
	{
		return this.patientcategory;
	}
	
	public Integer getPendingAdmissionAnticipatedStay()
	{
		return null;
	}
	
	public ims.core.vo.lookups.SourceOfEmergencyReferral getPendingAdmissionSourceOfEmergencyReferral()
	{
		return null;
	}
	
	public ims.core.vo.lookups.SourceOfReferral getPendingAdmissionSourceOfReferral()
	{
		return null;
	}
	
	public String getPendingAdmissionReasonForAdmission()
	{
		return null;
	}
	
	public MedicLiteVo getPendingAdmissionReferringConsultant()
	{
		return null;
	}
	
	public Boolean getPendingAdmissionSelfAdmit()
	{
		return null;
	}
	
	/**
	* getHospnum
	*/
	public ims.core.vo.PatientId getHospnum()
	{
		return getPatId(ims.core.vo.lookups.PatIdType.HOSPNUM);
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
		if(this.name != null)
		{
			if(!this.name.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.identifiers != null)
		{
			if(!this.identifiers.isValidated())
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
		if(this.name != null)
		{
			String[] listOfOtherErrors = this.name.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.primaryidvalueused != null)
			if(this.primaryidvalueused.length() > 50)
				listOfErrors.add("The length of the field [primaryidvalueused] in the value object [ims.core.vo.PatientLite_IdentifiersVo] is too big. It should be less or equal to 50");
		if(this.identifiers != null)
		{
			String[] listOfOtherErrors = this.identifiers.validate();
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
	
		PatientLite_IdentifiersVo clone = new PatientLite_IdentifiersVo(this.id, this.version);
		
		if(this.name == null)
			clone.name = null;
		else
			clone.name = (ims.core.vo.PersonName)this.name.clone();
		if(this.sex == null)
			clone.sex = null;
		else
			clone.sex = (ims.core.vo.lookups.Sex)this.sex.clone();
		if(this.dob == null)
			clone.dob = null;
		else
			clone.dob = (ims.framework.utils.PartialDate)this.dob.clone();
		clone.isactive = this.isactive;
		clone.isquickregistrationpatient = this.isquickregistrationpatient;
		clone.primaryidvalueused = this.primaryidvalueused;
		if(this.identifiers == null)
			clone.identifiers = null;
		else
			clone.identifiers = (ims.core.vo.PatientIdCollection)this.identifiers.clone();
		if(this.dod == null)
			clone.dod = null;
		else
			clone.dod = (ims.framework.utils.Date)this.dod.clone();
		clone.age = this.age;
		clone.agetext = this.agetext;
		if(this.patientcategory == null)
			clone.patientcategory = null;
		else
			clone.patientcategory = (ims.core.vo.lookups.PatientStatus)this.patientcategory.clone();
		clone.patientalerts = this.patientalerts;
		clone.hasalerts = this.hasalerts;
		clone.associatedpatient = this.associatedpatient;
		if(this.ward == null)
			clone.ward = null;
		else
			clone.ward = (ims.core.vo.LocationLiteVo)this.ward.clone();
		clone.isselfadmitpatient = this.isselfadmitpatient;
		if(this.timeofdeath == null)
			clone.timeofdeath = null;
		else
			clone.timeofdeath = (ims.framework.utils.Time)this.timeofdeath.clone();
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
		if (!(PatientLite_IdentifiersVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientLite_IdentifiersVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientLite_IdentifiersVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientLite_IdentifiersVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.patientcategory != null)
			count++;
		if(this.patientalerts != null)
			count++;
		if(this.hasalerts != null)
			count++;
		if(this.associatedpatient != null)
			count++;
		if(this.ward != null)
			count++;
		if(this.isselfadmitpatient != null)
			count++;
		if(this.timeofdeath != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 7;
	}
	protected ims.core.vo.lookups.PatientStatus patientcategory;
	protected ims.core.clinical.vo.PatientAlertRefVoCollection patientalerts;
	protected Boolean hasalerts;
	protected ims.core.patient.vo.PatientRefVo associatedpatient;
	protected ims.core.vo.LocationLiteVo ward;
	protected Boolean isselfadmitpatient;
	protected ims.framework.utils.Time timeofdeath;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
