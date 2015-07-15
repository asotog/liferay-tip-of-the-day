/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.rivetlogic.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rivetlogic.model.TipsOfTheDayVisited;

import com.rivetlogic.service.TipsOfTheDayVisitedService;
import com.rivetlogic.service.persistence.TipsOfTheDayCategoriesPersistence;
import com.rivetlogic.service.persistence.TipsOfTheDayUsersPersistence;
import com.rivetlogic.service.persistence.TipsOfTheDayVisitedPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the Tips of the Day Visited remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rivetlogic.service.impl.TipsOfTheDayVisitedServiceImpl}.
 * </p>
 *
 * @author juancarrillo
 * @see com.rivetlogic.service.impl.TipsOfTheDayVisitedServiceImpl
 * @see com.rivetlogic.service.TipsOfTheDayVisitedServiceUtil
 * @generated
 */
public abstract class TipsOfTheDayVisitedServiceBaseImpl extends BaseServiceImpl
	implements TipsOfTheDayVisitedService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rivetlogic.service.TipsOfTheDayVisitedServiceUtil} to access the Tips of the Day Visited remote service.
	 */

	/**
	 * Returns the Tips of the Day Categories local service.
	 *
	 * @return the Tips of the Day Categories local service
	 */
	public com.rivetlogic.service.TipsOfTheDayCategoriesLocalService getTipsOfTheDayCategoriesLocalService() {
		return tipsOfTheDayCategoriesLocalService;
	}

	/**
	 * Sets the Tips of the Day Categories local service.
	 *
	 * @param tipsOfTheDayCategoriesLocalService the Tips of the Day Categories local service
	 */
	public void setTipsOfTheDayCategoriesLocalService(
		com.rivetlogic.service.TipsOfTheDayCategoriesLocalService tipsOfTheDayCategoriesLocalService) {
		this.tipsOfTheDayCategoriesLocalService = tipsOfTheDayCategoriesLocalService;
	}

	/**
	 * Returns the Tips of the Day Categories remote service.
	 *
	 * @return the Tips of the Day Categories remote service
	 */
	public com.rivetlogic.service.TipsOfTheDayCategoriesService getTipsOfTheDayCategoriesService() {
		return tipsOfTheDayCategoriesService;
	}

	/**
	 * Sets the Tips of the Day Categories remote service.
	 *
	 * @param tipsOfTheDayCategoriesService the Tips of the Day Categories remote service
	 */
	public void setTipsOfTheDayCategoriesService(
		com.rivetlogic.service.TipsOfTheDayCategoriesService tipsOfTheDayCategoriesService) {
		this.tipsOfTheDayCategoriesService = tipsOfTheDayCategoriesService;
	}

	/**
	 * Returns the Tips of the Day Categories persistence.
	 *
	 * @return the Tips of the Day Categories persistence
	 */
	public TipsOfTheDayCategoriesPersistence getTipsOfTheDayCategoriesPersistence() {
		return tipsOfTheDayCategoriesPersistence;
	}

	/**
	 * Sets the Tips of the Day Categories persistence.
	 *
	 * @param tipsOfTheDayCategoriesPersistence the Tips of the Day Categories persistence
	 */
	public void setTipsOfTheDayCategoriesPersistence(
		TipsOfTheDayCategoriesPersistence tipsOfTheDayCategoriesPersistence) {
		this.tipsOfTheDayCategoriesPersistence = tipsOfTheDayCategoriesPersistence;
	}

	/**
	 * Returns the Tips of the Day Users local service.
	 *
	 * @return the Tips of the Day Users local service
	 */
	public com.rivetlogic.service.TipsOfTheDayUsersLocalService getTipsOfTheDayUsersLocalService() {
		return tipsOfTheDayUsersLocalService;
	}

	/**
	 * Sets the Tips of the Day Users local service.
	 *
	 * @param tipsOfTheDayUsersLocalService the Tips of the Day Users local service
	 */
	public void setTipsOfTheDayUsersLocalService(
		com.rivetlogic.service.TipsOfTheDayUsersLocalService tipsOfTheDayUsersLocalService) {
		this.tipsOfTheDayUsersLocalService = tipsOfTheDayUsersLocalService;
	}

	/**
	 * Returns the Tips of the Day Users remote service.
	 *
	 * @return the Tips of the Day Users remote service
	 */
	public com.rivetlogic.service.TipsOfTheDayUsersService getTipsOfTheDayUsersService() {
		return tipsOfTheDayUsersService;
	}

	/**
	 * Sets the Tips of the Day Users remote service.
	 *
	 * @param tipsOfTheDayUsersService the Tips of the Day Users remote service
	 */
	public void setTipsOfTheDayUsersService(
		com.rivetlogic.service.TipsOfTheDayUsersService tipsOfTheDayUsersService) {
		this.tipsOfTheDayUsersService = tipsOfTheDayUsersService;
	}

	/**
	 * Returns the Tips of the Day Users persistence.
	 *
	 * @return the Tips of the Day Users persistence
	 */
	public TipsOfTheDayUsersPersistence getTipsOfTheDayUsersPersistence() {
		return tipsOfTheDayUsersPersistence;
	}

	/**
	 * Sets the Tips of the Day Users persistence.
	 *
	 * @param tipsOfTheDayUsersPersistence the Tips of the Day Users persistence
	 */
	public void setTipsOfTheDayUsersPersistence(
		TipsOfTheDayUsersPersistence tipsOfTheDayUsersPersistence) {
		this.tipsOfTheDayUsersPersistence = tipsOfTheDayUsersPersistence;
	}

	/**
	 * Returns the Tips of the Day Visited local service.
	 *
	 * @return the Tips of the Day Visited local service
	 */
	public com.rivetlogic.service.TipsOfTheDayVisitedLocalService getTipsOfTheDayVisitedLocalService() {
		return tipsOfTheDayVisitedLocalService;
	}

	/**
	 * Sets the Tips of the Day Visited local service.
	 *
	 * @param tipsOfTheDayVisitedLocalService the Tips of the Day Visited local service
	 */
	public void setTipsOfTheDayVisitedLocalService(
		com.rivetlogic.service.TipsOfTheDayVisitedLocalService tipsOfTheDayVisitedLocalService) {
		this.tipsOfTheDayVisitedLocalService = tipsOfTheDayVisitedLocalService;
	}

	/**
	 * Returns the Tips of the Day Visited remote service.
	 *
	 * @return the Tips of the Day Visited remote service
	 */
	public com.rivetlogic.service.TipsOfTheDayVisitedService getTipsOfTheDayVisitedService() {
		return tipsOfTheDayVisitedService;
	}

	/**
	 * Sets the Tips of the Day Visited remote service.
	 *
	 * @param tipsOfTheDayVisitedService the Tips of the Day Visited remote service
	 */
	public void setTipsOfTheDayVisitedService(
		com.rivetlogic.service.TipsOfTheDayVisitedService tipsOfTheDayVisitedService) {
		this.tipsOfTheDayVisitedService = tipsOfTheDayVisitedService;
	}

	/**
	 * Returns the Tips of the Day Visited persistence.
	 *
	 * @return the Tips of the Day Visited persistence
	 */
	public TipsOfTheDayVisitedPersistence getTipsOfTheDayVisitedPersistence() {
		return tipsOfTheDayVisitedPersistence;
	}

	/**
	 * Sets the Tips of the Day Visited persistence.
	 *
	 * @param tipsOfTheDayVisitedPersistence the Tips of the Day Visited persistence
	 */
	public void setTipsOfTheDayVisitedPersistence(
		TipsOfTheDayVisitedPersistence tipsOfTheDayVisitedPersistence) {
		this.tipsOfTheDayVisitedPersistence = tipsOfTheDayVisitedPersistence;
	}

	/**
	 * Returns the Web Article helper local service.
	 *
	 * @return the Web Article helper local service
	 */
	public com.rivetlogic.service.WebArticleHelperLocalService getWebArticleHelperLocalService() {
		return webArticleHelperLocalService;
	}

	/**
	 * Sets the Web Article helper local service.
	 *
	 * @param webArticleHelperLocalService the Web Article helper local service
	 */
	public void setWebArticleHelperLocalService(
		com.rivetlogic.service.WebArticleHelperLocalService webArticleHelperLocalService) {
		this.webArticleHelperLocalService = webArticleHelperLocalService;
	}

	/**
	 * Returns the Web Article helper remote service.
	 *
	 * @return the Web Article helper remote service
	 */
	public com.rivetlogic.service.WebArticleHelperService getWebArticleHelperService() {
		return webArticleHelperService;
	}

	/**
	 * Sets the Web Article helper remote service.
	 *
	 * @param webArticleHelperService the Web Article helper remote service
	 */
	public void setWebArticleHelperService(
		com.rivetlogic.service.WebArticleHelperService webArticleHelperService) {
		this.webArticleHelperService = webArticleHelperService;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return TipsOfTheDayVisited.class;
	}

	protected String getModelClassName() {
		return TipsOfTheDayVisited.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = tipsOfTheDayVisitedPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rivetlogic.service.TipsOfTheDayCategoriesLocalService.class)
	protected com.rivetlogic.service.TipsOfTheDayCategoriesLocalService tipsOfTheDayCategoriesLocalService;
	@BeanReference(type = com.rivetlogic.service.TipsOfTheDayCategoriesService.class)
	protected com.rivetlogic.service.TipsOfTheDayCategoriesService tipsOfTheDayCategoriesService;
	@BeanReference(type = TipsOfTheDayCategoriesPersistence.class)
	protected TipsOfTheDayCategoriesPersistence tipsOfTheDayCategoriesPersistence;
	@BeanReference(type = com.rivetlogic.service.TipsOfTheDayUsersLocalService.class)
	protected com.rivetlogic.service.TipsOfTheDayUsersLocalService tipsOfTheDayUsersLocalService;
	@BeanReference(type = com.rivetlogic.service.TipsOfTheDayUsersService.class)
	protected com.rivetlogic.service.TipsOfTheDayUsersService tipsOfTheDayUsersService;
	@BeanReference(type = TipsOfTheDayUsersPersistence.class)
	protected TipsOfTheDayUsersPersistence tipsOfTheDayUsersPersistence;
	@BeanReference(type = com.rivetlogic.service.TipsOfTheDayVisitedLocalService.class)
	protected com.rivetlogic.service.TipsOfTheDayVisitedLocalService tipsOfTheDayVisitedLocalService;
	@BeanReference(type = com.rivetlogic.service.TipsOfTheDayVisitedService.class)
	protected com.rivetlogic.service.TipsOfTheDayVisitedService tipsOfTheDayVisitedService;
	@BeanReference(type = TipsOfTheDayVisitedPersistence.class)
	protected TipsOfTheDayVisitedPersistence tipsOfTheDayVisitedPersistence;
	@BeanReference(type = com.rivetlogic.service.WebArticleHelperLocalService.class)
	protected com.rivetlogic.service.WebArticleHelperLocalService webArticleHelperLocalService;
	@BeanReference(type = com.rivetlogic.service.WebArticleHelperService.class)
	protected com.rivetlogic.service.WebArticleHelperService webArticleHelperService;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private TipsOfTheDayVisitedServiceClpInvoker _clpInvoker = new TipsOfTheDayVisitedServiceClpInvoker();
}