/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.services.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.rivetlogic.services.model.TipsOfTheDayUsers;
import com.rivetlogic.services.service.base.TipsOfTheDayUsersLocalServiceBaseImpl;
import com.rivetlogic.tipday.api.constants.WebKeys;

/**
 * The implementation of the Tips of the Day Users local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.services.service.TipsOfTheDayUsersLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayUsersLocalServiceBaseImpl
 * @see com.rivetlogic.services.service.TipsOfTheDayUsersLocalServiceUtil
 */
public class TipsOfTheDayUsersLocalServiceImpl
	extends TipsOfTheDayUsersLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.rivetlogic.services.service.TipsOfTheDayUsersLocalServiceUtil} to access the Tips of the Day Users local service.
	 */
	
	public void setUserStatus(long companyId, long groupId, long userId, String status) 
			throws SystemException, PortalException {
		TipsOfTheDayUsers user = getUser(companyId, groupId, userId);
		user.setStatus(status);
		tipsOfTheDayUsersPersistence.update(user);
	}
	
	public void setUserShowAll(long companyId, long groupId, long userId, Boolean showAll)
	        throws SystemException, PortalException {
	    TipsOfTheDayUsers user = getUser(companyId, groupId, userId);
	    user.setShowAll(showAll);
	    tipsOfTheDayUsersPersistence.update(user);
	}
	
	public TipsOfTheDayUsers getUser(long companyId, long groupId, long userId) 
			throws SystemException, PortalException {
		
		String status = String.valueOf(WebKeys.STATUS_RECEIVE);
		
		TipsOfTheDayUsers user = 
				tipsOfTheDayUsersPersistence.fetchByC_G_U(
						companyId, groupId, userId);
		
		if (Validator.isNull(user)) {
			user = tipsOfTheDayUsersPersistence.create(
					counterLocalService.increment(
							TipsOfTheDayUsers.class.getName()));
			
			user.setCompanyId(companyId);
			user.setGroupId(groupId);
			user.setUserId(userId);
			user.setStatus(status);
			user.setShowAll(WebKeys.SHOW_ALL_DEFAULT);
			user.setNew(true);
		}
		
		return user;
	}
	
	public String getUserStatus(long companyId, long groupId, long userId) 
			throws SystemException, PortalException  {
	    TipsOfTheDayUsers user = getUser(companyId, groupId, userId);
        return user.getStatus();
	}
	
	public boolean getUserShowAll(long companyId, long groupId, long userId)
	        throws SystemException, PortalException {
	    TipsOfTheDayUsers user = getUser(companyId, groupId, userId);
	    return user.getShowAll();
	}
}