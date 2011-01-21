/*
 *  soapUI, copyright (C) 2004-2011 eviware.com 
 *
 *  soapUI is free software; you can redistribute it and/or modify it under the 
 *  terms of version 2.1 of the GNU Lesser General Public License as published by 
 *  the Free Software Foundation.
 *
 *  soapUI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU Lesser General Public License for more details at gnu.org.
 */

package com.eviware.soapui.security.registry;

import com.eviware.soapui.config.SecurityCheckConfig;
import com.eviware.soapui.config.XmlBombSecurityCheckConfig;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.security.check.SecurityCheck;
import com.eviware.soapui.security.check.XmlBombSecurityCheck;

/**
 * Factory for creation GroovyScript steps
 * 
 * @author soapUI team
 */

public class XmlBombSecurityCheckFactory extends AbstractSecurityCheckFactory {
	
	public XmlBombSecurityCheckFactory() {
		super(XmlBombSecurityCheck.TYPE, "XmlBombSecurityCheck",
				"Preforms a check for XML Bomb Vulerabilities",
				"/xml_bomb_security_check_script.gif");
	}

	public boolean canCreate() {
		return true;
	}

	@Override
	public SecurityCheck buildSecurityCheck(SecurityCheckConfig config, ModelItem parent) {
		return new XmlBombSecurityCheck(config, null, null);
	}

	@Override
	public SecurityCheckConfig createNewSecurityCheck(String name) {
		SecurityCheckConfig securityCheckConfig = SecurityCheckConfig.Factory
				.newInstance();
		securityCheckConfig.setType(XmlBombSecurityCheck.TYPE);
		securityCheckConfig.setName(name);
		XmlBombSecurityCheckConfig xbsc = XmlBombSecurityCheckConfig.Factory.newInstance();
		securityCheckConfig.setConfig(xbsc);
		return securityCheckConfig;
	}

	@Override
	public boolean isHttpMonitor() {
		return false;
	}
}
