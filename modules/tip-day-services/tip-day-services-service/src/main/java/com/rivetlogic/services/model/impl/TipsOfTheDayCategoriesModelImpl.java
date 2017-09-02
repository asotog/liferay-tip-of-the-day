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

package com.rivetlogic.services.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.rivetlogic.services.model.TipsOfTheDayCategories;
import com.rivetlogic.services.model.TipsOfTheDayCategoriesModel;
import com.rivetlogic.services.model.TipsOfTheDayCategoriesSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TipsOfTheDayCategories service. Represents a row in the &quot;rivetlogic_tipday_TipsOfTheDayCategories&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TipsOfTheDayCategoriesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TipsOfTheDayCategoriesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayCategoriesImpl
 * @see TipsOfTheDayCategories
 * @see TipsOfTheDayCategoriesModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TipsOfTheDayCategoriesModelImpl extends BaseModelImpl<TipsOfTheDayCategories>
	implements TipsOfTheDayCategoriesModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a Tips of the Day Categories model instance should use the {@link TipsOfTheDayCategories} interface instead.
	 */
	public static final String TABLE_NAME = "rivetlogic_tipday_TipsOfTheDayCategories";
	public static final Object[][] TABLE_COLUMNS = {
			{ "groupId", Types.BIGINT },
			{ "categories", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("categories", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table rivetlogic_tipday_TipsOfTheDayCategories (groupId LONG not null primary key,categories VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table rivetlogic_tipday_TipsOfTheDayCategories";
	public static final String ORDER_BY_JPQL = " ORDER BY tipsOfTheDayCategories.groupId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY rivetlogic_tipday_TipsOfTheDayCategories.groupId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.rivetlogic.services.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rivetlogic.services.model.TipsOfTheDayCategories"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.rivetlogic.services.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rivetlogic.services.model.TipsOfTheDayCategories"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TipsOfTheDayCategories toModel(
		TipsOfTheDayCategoriesSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TipsOfTheDayCategories model = new TipsOfTheDayCategoriesImpl();

		model.setGroupId(soapModel.getGroupId());
		model.setCategories(soapModel.getCategories());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TipsOfTheDayCategories> toModels(
		TipsOfTheDayCategoriesSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TipsOfTheDayCategories> models = new ArrayList<TipsOfTheDayCategories>(soapModels.length);

		for (TipsOfTheDayCategoriesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.rivetlogic.services.service.util.ServiceProps.get(
				"lock.expiration.time.com.rivetlogic.services.model.TipsOfTheDayCategories"));

	public TipsOfTheDayCategoriesModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _groupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TipsOfTheDayCategories.class;
	}

	@Override
	public String getModelClassName() {
		return TipsOfTheDayCategories.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("categories", getCategories());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String categories = (String)attributes.get("categories");

		if (categories != null) {
			setCategories(categories);
		}
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public String getCategories() {
		if (_categories == null) {
			return StringPool.BLANK;
		}
		else {
			return _categories;
		}
	}

	@Override
	public void setCategories(String categories) {
		_categories = categories;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TipsOfTheDayCategories.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TipsOfTheDayCategories toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TipsOfTheDayCategories)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TipsOfTheDayCategoriesImpl tipsOfTheDayCategoriesImpl = new TipsOfTheDayCategoriesImpl();

		tipsOfTheDayCategoriesImpl.setGroupId(getGroupId());
		tipsOfTheDayCategoriesImpl.setCategories(getCategories());

		tipsOfTheDayCategoriesImpl.resetOriginalValues();

		return tipsOfTheDayCategoriesImpl;
	}

	@Override
	public int compareTo(TipsOfTheDayCategories tipsOfTheDayCategories) {
		long primaryKey = tipsOfTheDayCategories.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipsOfTheDayCategories)) {
			return false;
		}

		TipsOfTheDayCategories tipsOfTheDayCategories = (TipsOfTheDayCategories)obj;

		long primaryKey = tipsOfTheDayCategories.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<TipsOfTheDayCategories> toCacheModel() {
		TipsOfTheDayCategoriesCacheModel tipsOfTheDayCategoriesCacheModel = new TipsOfTheDayCategoriesCacheModel();

		tipsOfTheDayCategoriesCacheModel.groupId = getGroupId();

		tipsOfTheDayCategoriesCacheModel.categories = getCategories();

		String categories = tipsOfTheDayCategoriesCacheModel.categories;

		if ((categories != null) && (categories.length() == 0)) {
			tipsOfTheDayCategoriesCacheModel.categories = null;
		}

		return tipsOfTheDayCategoriesCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{groupId=");
		sb.append(getGroupId());
		sb.append(", categories=");
		sb.append(getCategories());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.services.model.TipsOfTheDayCategories");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categories</column-name><column-value><![CDATA[");
		sb.append(getCategories());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TipsOfTheDayCategories.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TipsOfTheDayCategories.class
		};
	private long _groupId;
	private String _categories;
	private TipsOfTheDayCategories _escapedModel;
}