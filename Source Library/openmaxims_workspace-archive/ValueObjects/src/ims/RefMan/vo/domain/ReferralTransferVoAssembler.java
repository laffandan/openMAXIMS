/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:31
 *
 */
package ims.RefMan.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Rory Fitzpatrick
 */
public class ReferralTransferVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.RefMan.vo.ReferralTransferVo copy(ims.RefMan.vo.ReferralTransferVo valueObjectDest, ims.RefMan.vo.ReferralTransferVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ReferralTransfer(valueObjectSrc.getID_ReferralTransfer());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// RTTStatusDate
		valueObjectDest.setRTTStatusDate(valueObjectSrc.getRTTStatusDate());
		// OtherPatientNumber
		valueObjectDest.setOtherPatientNumber(valueObjectSrc.getOtherPatientNumber());
		// OTherOrganisationCode
		valueObjectDest.setOTherOrganisationCode(valueObjectSrc.getOTherOrganisationCode());
		// CurrentRTTStatus
		valueObjectDest.setCurrentRTTStatus(valueObjectSrc.getCurrentRTTStatus());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createReferralTransferVoCollectionFromReferralTransfer(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.ReferralTransfer objects.
	 */
	public static ims.RefMan.vo.ReferralTransferVoCollection createReferralTransferVoCollectionFromReferralTransfer(java.util.Set domainObjectSet)	
	{
		return createReferralTransferVoCollectionFromReferralTransfer(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.RefMan.domain.objects.ReferralTransfer objects.
	 */
	public static ims.RefMan.vo.ReferralTransferVoCollection createReferralTransferVoCollectionFromReferralTransfer(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.RefMan.vo.ReferralTransferVoCollection voList = new ims.RefMan.vo.ReferralTransferVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.RefMan.domain.objects.ReferralTransfer domainObject = (ims.RefMan.domain.objects.ReferralTransfer) iterator.next();
			ims.RefMan.vo.ReferralTransferVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.RefMan.domain.objects.ReferralTransfer objects.
	 */
	public static ims.RefMan.vo.ReferralTransferVoCollection createReferralTransferVoCollectionFromReferralTransfer(java.util.List domainObjectList) 
	{
		return createReferralTransferVoCollectionFromReferralTransfer(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.RefMan.domain.objects.ReferralTransfer objects.
	 */
	public static ims.RefMan.vo.ReferralTransferVoCollection createReferralTransferVoCollectionFromReferralTransfer(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.RefMan.vo.ReferralTransferVoCollection voList = new ims.RefMan.vo.ReferralTransferVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.RefMan.domain.objects.ReferralTransfer domainObject = (ims.RefMan.domain.objects.ReferralTransfer) domainObjectList.get(i);
			ims.RefMan.vo.ReferralTransferVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.RefMan.domain.objects.ReferralTransfer set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractReferralTransferSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ReferralTransferVoCollection voCollection) 
	 {
	 	return extractReferralTransferSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractReferralTransferSet(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ReferralTransferVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.ReferralTransferVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.ReferralTransfer domainObject = ReferralTransferVoAssembler.extractReferralTransfer(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.RefMan.domain.objects.ReferralTransfer list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractReferralTransferList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ReferralTransferVoCollection voCollection) 
	 {
	 	return extractReferralTransferList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractReferralTransferList(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ReferralTransferVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.RefMan.vo.ReferralTransferVo vo = voCollection.get(i);
			ims.RefMan.domain.objects.ReferralTransfer domainObject = ReferralTransferVoAssembler.extractReferralTransfer(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.RefMan.domain.objects.ReferralTransfer object.
	 * @param domainObject ims.RefMan.domain.objects.ReferralTransfer
	 */
	 public static ims.RefMan.vo.ReferralTransferVo create(ims.RefMan.domain.objects.ReferralTransfer domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.RefMan.domain.objects.ReferralTransfer object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.RefMan.vo.ReferralTransferVo create(DomainObjectMap map, ims.RefMan.domain.objects.ReferralTransfer domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.RefMan.vo.ReferralTransferVo valueObject = (ims.RefMan.vo.ReferralTransferVo) map.getValueObject(domainObject, ims.RefMan.vo.ReferralTransferVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.RefMan.vo.ReferralTransferVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.RefMan.domain.objects.ReferralTransfer
	 */
	 public static ims.RefMan.vo.ReferralTransferVo insert(ims.RefMan.vo.ReferralTransferVo valueObject, ims.RefMan.domain.objects.ReferralTransfer domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.RefMan.domain.objects.ReferralTransfer
	 */
	 public static ims.RefMan.vo.ReferralTransferVo insert(DomainObjectMap map, ims.RefMan.vo.ReferralTransferVo valueObject, ims.RefMan.domain.objects.ReferralTransfer domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ReferralTransfer(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// RTTStatusDate
		java.util.Date RTTStatusDate = domainObject.getRTTStatusDate();
		if ( null != RTTStatusDate ) 
		{
			valueObject.setRTTStatusDate(new ims.framework.utils.Date(RTTStatusDate) );
		}
		// OtherPatientNumber
		valueObject.setOtherPatientNumber(domainObject.getOtherPatientNumber());
		// OTherOrganisationCode
		valueObject.setOTherOrganisationCode(domainObject.getOTherOrganisationCode());
		// CurrentRTTStatus
		valueObject.setCurrentRTTStatus(ims.pathways.vo.domain.RTTStatusPointVoAssembler.create(map, domainObject.getCurrentRTTStatus()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.RefMan.domain.objects.ReferralTransfer extractReferralTransfer(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ReferralTransferVo valueObject) 
	{
		return 	extractReferralTransfer(domainFactory, valueObject, new HashMap());
	}

	public static ims.RefMan.domain.objects.ReferralTransfer extractReferralTransfer(ims.domain.ILightweightDomainFactory domainFactory, ims.RefMan.vo.ReferralTransferVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ReferralTransfer();
		ims.RefMan.domain.objects.ReferralTransfer domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.RefMan.domain.objects.ReferralTransfer)domMap.get(valueObject);
			}
			// ims.RefMan.vo.ReferralTransferVo ID_ReferralTransfer field is unknown
			domainObject = new ims.RefMan.domain.objects.ReferralTransfer();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ReferralTransfer());
			if (domMap.get(key) != null)
			{
				return (ims.RefMan.domain.objects.ReferralTransfer)domMap.get(key);
			}
			domainObject = (ims.RefMan.domain.objects.ReferralTransfer) domainFactory.getDomainObject(ims.RefMan.domain.objects.ReferralTransfer.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ReferralTransfer());

		java.util.Date value1 = null;
		ims.framework.utils.Date date1 = valueObject.getRTTStatusDate();		
		if ( date1 != null ) 
		{
			value1 = date1.getDate();
		}
		domainObject.setRTTStatusDate(value1);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getOtherPatientNumber() != null && valueObject.getOtherPatientNumber().equals(""))
		{
			valueObject.setOtherPatientNumber(null);
		}
		domainObject.setOtherPatientNumber(valueObject.getOtherPatientNumber());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getOTherOrganisationCode() != null && valueObject.getOTherOrganisationCode().equals(""))
		{
			valueObject.setOTherOrganisationCode(null);
		}
		domainObject.setOTherOrganisationCode(valueObject.getOTherOrganisationCode());
		domainObject.setCurrentRTTStatus(ims.pathways.vo.domain.RTTStatusPointVoAssembler.extractRTTStatusPoint(domainFactory, valueObject.getCurrentRTTStatus(), domMap));

		return domainObject;
	}

}
