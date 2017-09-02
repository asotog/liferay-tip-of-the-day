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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.rivetlogic.services.model.TipsOfTheDayUsers;
import com.rivetlogic.services.model.TipsOfTheDayUsersModel;
import com.rivetlogic.services.model.TipsOfTheDayUsersSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TipsOfTheDayUsers service. Represents a row in the &quot;rivetlogic_tipday_TipsOfTheDayUsers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TipsOfTheDayUsersModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TipsOfTheDayUsersImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TipsOfTheDayUsersImpl
 * @see TipsOfTheDayUsers
 * @see TipsOfTheDayUsersModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TipsOfTheDayUsersModelImpl extends BaseModelImpl<TipsOfTheDayUsers>
	implements TipsOfTheDayUsersModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a Tips of the Day Users model instance should use the {@link TipsOfTheDayUsers} interface instead.
	 */
	public static final String TABLE_NAME = "rivetlogic_tipday_TipsOfTheDayUsers";
	public static final Object[][] TABLE_COLUMNS = {
			{ "tipUserId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "status", Types.VARCHAR },
			{ "showAll", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("tipUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("showAll", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table rivetlogic_tipday_TipsOfTheDayUsers (tipUserId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,status VARCHAR(75) null,showAll BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table rivetlogic_tipday_TipsOfTheDayUsers";
	public static final String ORDER_BY_JPQL = " ORDER BY tipsOfTheDayUsers.tipUserId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY rivetlogic_tipday_TipsOfTheDayUsers.tipUserId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.rivetlogic.services.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rivetlogic.services.model.TipsOfTheDayUsers"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.rivetlogic.services.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rivetlogic.services.model.TipsOfTheDayUsers"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.rivetlogic.services.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rivetlogic.services.model.TipsOfTheDayUsers"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long USERID_COLUMN_BITMASK = 4L;
	public static final long TIPUSERID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TipsOfTheDayUsers toModel(TipsOfTheDayUsersSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TipsOfTheDayUsers model = new TipsOfTheDayUsersImpl();

		model.setTipUserId(soapModel.getTipUserId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setStatus(soapModel.getStatus());
		model.setShowAll(soapModel.getShowAll());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TipsOfTheDayUsers> toModels(
		TipsOfTheDayUsersSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TipsOfTheDayUsers> models = new ArrayList<TipsOfTheDayUsers>(soapModels.length);

		for (TipsOfTheDayUsersSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.rivetlogic.services.service.util.ServiceProps.get(
				"lock.expiration.time.com.rivetlogic.services.model.TipsOfTheDayUsers"));

	public TipsOfTheDayUsersModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _tipUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTipUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TipsOfTheDayUsers.class;
	}

	@Override
	public String getModelClassName() {
		return TipsOfTheDayUsers.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tipUserId", getTipUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("status", getStatus());
		attributes.put("showAll", getShowAll());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tipUserId = (Long)attributes.get("tipUserId");

		if (tipUserId != null) {
			setTipUserId(tipUserId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean showAll = (Boolean)attributes.get("showAll");

		if (showAll != null) {
			setShowAll(showAll);
		}
	}

	@JSON
	@Override
	public long getTipUserId() {
		return _tipUserId;
	}

	@Override
	public void setTipUserId(long tipUserId) {
		_tipUserId = tipUserId;
	}

	@Override
	public String getTipUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getTipUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setTipUserUuid(String tipUserUuid) {
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_status = status;
	}

	@JSON
	@Override
	public boolean getShowAll() {
		return _showAll;
	}

	@JSON
	@Override
	public boolean isShowAll() {
		return _showAll;
	}

	@Override
	public void setShowAll(boolean showAll) {
		_showAll = showAll;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			TipsOfTheDayUsers.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TipsOfTheDayUsers toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TipsOfTheDayUsers)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TipsOfTheDayUsersImpl tipsOfTheDayUsersImpl = new TipsOfTheDayUsersImpl();

		tipsOfTheDayUsersImpl.setTipUserId(getTipUserId());
		tipsOfTheDayUsersImpl.setCompanyId(getCompanyId());
		tipsOfTheDayUsersImpl.setGroupId(getGroupId());
		tipsOfTheDayUsersImpl.setUserId(getUserId());
		tipsOfTheDayUsersImpl.setStatus(getStatus());
		tipsOfTheDayUsersImpl.setShowAll(getShowAll());

		tipsOfTheDayUsersImpl.resetOriginalValues();

		return tipsOfTheDayUsersImpl;
	}

	@Override
	public int compareTo(TipsOfTheDayUsers tipsOfTheDayUsers) {
		long primaryKey = tipsOfTheDayUsers.getPrimaryKey();

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

		if (!(obj instanceof TipsOfTheDayUsers)) {
			return false;
		}

		TipsOfTheDayUsers tipsOfTheDayUsers = (TipsOfTheDayUsers)obj;

		long primaryKey = tipsOfTheDayUsers.getPrimaryKey();

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
		TipsOfTheDayUsersModelImpl tipsOfTheDayUsersModelImpl = this;

		tipsOfTheDayUsersModelImpl._originalCompanyId = tipsOfTheDayUsersModelImpl._companyId;

		tipsOfTheDayUsersModelImpl._setOriginalCompanyId = false;

		tipsOfTheDayUsersModelImpl._originalGroupId = tipsOfTheDayUsersModelImpl._groupId;

		tipsOfTheDayUsersModelImpl._setOriginalGroupId = false;

		tipsOfTheDayUsersModelImpl._originalUserId = tipsOfTheDayUsersModelImpl._userId;

		tipsOfTheDayUsersModelImpl._setOriginalUserId = false;

		tipsOfTheDayUsersModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TipsOfTheDayUsers> toCacheModel() {
		TipsOfTheDayUsersCacheModel tipsOfTheDayUsersCacheModel = new TipsOfTheDayUsersCacheModel();

		tipsOfTheDayUsersCacheModel.tipUserId = getTipUserId();

		tipsOfTheDayUsersCacheModel.companyId = getCompanyId();

		tipsOfTheDayUsersCacheModel.groupId = getGroupId();

		tipsOfTheDayUsersCacheModel.userId = getUserId();

		tipsOfTheDayUsersCacheModel.status = getStatus();

		String status = tipsOfTheDayUsersCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			tipsOfTheDayUsersCacheModel.status = null;
		}

		tipsOfTheDayUsersCacheModel.showAll = getShowAll();

		return tipsOfTheDayUsersCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{tipUserId=");
		sb.append(getTipUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", showAll=");
		sb.append(getShowAll());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.services.model.TipsOfTheDayUsers");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tipUserId</column-name><column-value><![CDATA[");
		sb.append(getTipUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>showAll</column-name><column-value><![CDATA[");
		sb.append(getShowAll());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TipsOfTheDayUsers.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TipsOfTheDayUsers.class
		};
	private long _tipUserId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _status;
	private boolean _showAll;
	private long _columnBitmask;
	private TipsOfTheDayUsers _escapedModel;
}