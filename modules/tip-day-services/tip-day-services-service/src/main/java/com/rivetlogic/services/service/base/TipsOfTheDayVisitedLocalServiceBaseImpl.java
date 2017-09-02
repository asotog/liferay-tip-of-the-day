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

package com.rivetlogic.services.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.rivetlogic.services.model.TipsOfTheDayVisited;
import com.rivetlogic.services.service.TipsOfTheDayVisitedLocalService;
import com.rivetlogic.services.service.persistence.TipsOfTheDayCategoriesPersistence;
import com.rivetlogic.services.service.persistence.TipsOfTheDayUsersPersistence;
import com.rivetlogic.services.service.persistence.TipsOfTheDayVisitedPK;
import com.rivetlogic.services.service.persistence.TipsOfTheDayVisitedPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the Tips of the Day Visited local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rivetlogic.services.service.impl.TipsOfTheDayVisitedLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rivetlogic.services.service.impl.TipsOfTheDayVisitedLocalServiceImpl
 * @see com.rivetlogic.services.service.TipsOfTheDayVisitedLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class TipsOfTheDayVisitedLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements TipsOfTheDayVisitedLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rivetlogic.services.service.TipsOfTheDayVisitedLocalServiceUtil} to access the Tips of the Day Visited local service.
	 */

	/**
	 * Adds the Tips of the Day Visited to the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipsOfTheDayVisited the Tips of the Day Visited
	 * @return the Tips of the Day Visited that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TipsOfTheDayVisited addTipsOfTheDayVisited(
		TipsOfTheDayVisited tipsOfTheDayVisited) {
		tipsOfTheDayVisited.setNew(true);

		return tipsOfTheDayVisitedPersistence.update(tipsOfTheDayVisited);
	}

	/**
	 * Creates a new Tips of the Day Visited with the primary key. Does not add the Tips of the Day Visited to the database.
	 *
	 * @param tipsOfTheDayVisitedPK the primary key for the new Tips of the Day Visited
	 * @return the new Tips of the Day Visited
	 */
	@Override
	public TipsOfTheDayVisited createTipsOfTheDayVisited(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK) {
		return tipsOfTheDayVisitedPersistence.create(tipsOfTheDayVisitedPK);
	}

	/**
	 * Deletes the Tips of the Day Visited with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	 * @return the Tips of the Day Visited that was removed
	 * @throws PortalException if a Tips of the Day Visited with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TipsOfTheDayVisited deleteTipsOfTheDayVisited(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK) throws PortalException {
		return tipsOfTheDayVisitedPersistence.remove(tipsOfTheDayVisitedPK);
	}

	/**
	 * Deletes the Tips of the Day Visited from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipsOfTheDayVisited the Tips of the Day Visited
	 * @return the Tips of the Day Visited that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TipsOfTheDayVisited deleteTipsOfTheDayVisited(
		TipsOfTheDayVisited tipsOfTheDayVisited) {
		return tipsOfTheDayVisitedPersistence.remove(tipsOfTheDayVisited);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(TipsOfTheDayVisited.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return tipsOfTheDayVisitedPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return tipsOfTheDayVisitedPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return tipsOfTheDayVisitedPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return tipsOfTheDayVisitedPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return tipsOfTheDayVisitedPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public TipsOfTheDayVisited fetchTipsOfTheDayVisited(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK) {
		return tipsOfTheDayVisitedPersistence.fetchByPrimaryKey(tipsOfTheDayVisitedPK);
	}

	/**
	 * Returns the Tips of the Day Visited with the primary key.
	 *
	 * @param tipsOfTheDayVisitedPK the primary key of the Tips of the Day Visited
	 * @return the Tips of the Day Visited
	 * @throws PortalException if a Tips of the Day Visited with the primary key could not be found
	 */
	@Override
	public TipsOfTheDayVisited getTipsOfTheDayVisited(
		TipsOfTheDayVisitedPK tipsOfTheDayVisitedPK) throws PortalException {
		return tipsOfTheDayVisitedPersistence.findByPrimaryKey(tipsOfTheDayVisitedPK);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(tipsOfTheDayVisitedLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TipsOfTheDayVisited.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("primaryKey.userId");

		actionableDynamicQuery.setGroupIdPropertyName("primaryKey.groupId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(tipsOfTheDayVisitedLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(TipsOfTheDayVisited.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.userId");

		indexableActionableDynamicQuery.setGroupIdPropertyName(
			"primaryKey.groupId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(tipsOfTheDayVisitedLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TipsOfTheDayVisited.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("primaryKey.userId");

		actionableDynamicQuery.setGroupIdPropertyName("primaryKey.groupId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return tipsOfTheDayVisitedLocalService.deleteTipsOfTheDayVisited((TipsOfTheDayVisited)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return tipsOfTheDayVisitedPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the Tips of the Day Visiteds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.services.model.impl.TipsOfTheDayVisitedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Tips of the Day Visiteds
	 * @param end the upper bound of the range of Tips of the Day Visiteds (not inclusive)
	 * @return the range of Tips of the Day Visiteds
	 */
	@Override
	public List<TipsOfTheDayVisited> getTipsOfTheDayVisiteds(int start, int end) {
		return tipsOfTheDayVisitedPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of Tips of the Day Visiteds.
	 *
	 * @return the number of Tips of the Day Visiteds
	 */
	@Override
	public int getTipsOfTheDayVisitedsCount() {
		return tipsOfTheDayVisitedPersistence.countAll();
	}

	/**
	 * Updates the Tips of the Day Visited in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param tipsOfTheDayVisited the Tips of the Day Visited
	 * @return the Tips of the Day Visited that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TipsOfTheDayVisited updateTipsOfTheDayVisited(
		TipsOfTheDayVisited tipsOfTheDayVisited) {
		return tipsOfTheDayVisitedPersistence.update(tipsOfTheDayVisited);
	}

	/**
	 * Returns the Tips of the Day Categories local service.
	 *
	 * @return the Tips of the Day Categories local service
	 */
	public com.rivetlogic.services.service.TipsOfTheDayCategoriesLocalService getTipsOfTheDayCategoriesLocalService() {
		return tipsOfTheDayCategoriesLocalService;
	}

	/**
	 * Sets the Tips of the Day Categories local service.
	 *
	 * @param tipsOfTheDayCategoriesLocalService the Tips of the Day Categories local service
	 */
	public void setTipsOfTheDayCategoriesLocalService(
		com.rivetlogic.services.service.TipsOfTheDayCategoriesLocalService tipsOfTheDayCategoriesLocalService) {
		this.tipsOfTheDayCategoriesLocalService = tipsOfTheDayCategoriesLocalService;
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
	public com.rivetlogic.services.service.TipsOfTheDayUsersLocalService getTipsOfTheDayUsersLocalService() {
		return tipsOfTheDayUsersLocalService;
	}

	/**
	 * Sets the Tips of the Day Users local service.
	 *
	 * @param tipsOfTheDayUsersLocalService the Tips of the Day Users local service
	 */
	public void setTipsOfTheDayUsersLocalService(
		com.rivetlogic.services.service.TipsOfTheDayUsersLocalService tipsOfTheDayUsersLocalService) {
		this.tipsOfTheDayUsersLocalService = tipsOfTheDayUsersLocalService;
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
	public TipsOfTheDayVisitedLocalService getTipsOfTheDayVisitedLocalService() {
		return tipsOfTheDayVisitedLocalService;
	}

	/**
	 * Sets the Tips of the Day Visited local service.
	 *
	 * @param tipsOfTheDayVisitedLocalService the Tips of the Day Visited local service
	 */
	public void setTipsOfTheDayVisitedLocalService(
		TipsOfTheDayVisitedLocalService tipsOfTheDayVisitedLocalService) {
		this.tipsOfTheDayVisitedLocalService = tipsOfTheDayVisitedLocalService;
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
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
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
		persistedModelLocalServiceRegistry.register("com.rivetlogic.services.model.TipsOfTheDayVisited",
			tipsOfTheDayVisitedLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.rivetlogic.services.model.TipsOfTheDayVisited");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TipsOfTheDayVisitedLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return TipsOfTheDayVisited.class;
	}

	protected String getModelClassName() {
		return TipsOfTheDayVisited.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = tipsOfTheDayVisitedPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rivetlogic.services.service.TipsOfTheDayCategoriesLocalService.class)
	protected com.rivetlogic.services.service.TipsOfTheDayCategoriesLocalService tipsOfTheDayCategoriesLocalService;
	@BeanReference(type = TipsOfTheDayCategoriesPersistence.class)
	protected TipsOfTheDayCategoriesPersistence tipsOfTheDayCategoriesPersistence;
	@BeanReference(type = com.rivetlogic.services.service.TipsOfTheDayUsersLocalService.class)
	protected com.rivetlogic.services.service.TipsOfTheDayUsersLocalService tipsOfTheDayUsersLocalService;
	@BeanReference(type = TipsOfTheDayUsersPersistence.class)
	protected TipsOfTheDayUsersPersistence tipsOfTheDayUsersPersistence;
	@BeanReference(type = TipsOfTheDayVisitedLocalService.class)
	protected TipsOfTheDayVisitedLocalService tipsOfTheDayVisitedLocalService;
	@BeanReference(type = TipsOfTheDayVisitedPersistence.class)
	protected TipsOfTheDayVisitedPersistence tipsOfTheDayVisitedPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}