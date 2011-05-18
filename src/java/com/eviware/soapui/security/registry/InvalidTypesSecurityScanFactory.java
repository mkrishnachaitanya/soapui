package com.eviware.soapui.security.registry;

import com.eviware.soapui.config.SecurityCheckConfig;
import com.eviware.soapui.impl.wsdl.teststeps.HttpTestRequestStep;
import com.eviware.soapui.impl.wsdl.teststeps.RestTestRequestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.security.scan.AbstractSecurityScan;
import com.eviware.soapui.security.scan.InvalidTypesSecurityScan;

public class InvalidTypesSecurityScanFactory extends AbstractSecurityScanFactory
{

	public InvalidTypesSecurityScanFactory()
	{
		super( InvalidTypesSecurityScan.TYPE, InvalidTypesSecurityScan.NAME,
				"Tries to break application and get information on system", "/information_exposure_check.gif" );
	}

	@Override
	public AbstractSecurityScan buildSecurityScan( TestStep testStep, SecurityCheckConfig config, ModelItem parent )
	{
		return new InvalidTypesSecurityScan( testStep, config, parent, null );
	}

	@Override
	public boolean canCreate( TestStep testStep )
	{
		return testStep instanceof WsdlTestRequestStep || testStep instanceof RestTestRequestStep
				|| testStep instanceof HttpTestRequestStep;
	}

	@Override
	public SecurityCheckConfig createNewSecurityScan( String name )
	{
		SecurityCheckConfig securityCheckConfig = SecurityCheckConfig.Factory.newInstance();
		securityCheckConfig.setType( InvalidTypesSecurityScan.TYPE );
		securityCheckConfig.setName( name );
		return securityCheckConfig;
	}

}