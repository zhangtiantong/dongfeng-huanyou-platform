package com.navinfo.opentsp.dongfeng.authority.handler;

import com.navinfo.opentsp.dongfeng.authority.commands.LoginCommand;
import com.navinfo.opentsp.dongfeng.authority.service.IAuthorityService;
import com.navinfo.opentsp.dongfeng.common.handler.NotValidateTokenAbstractHandler;
import com.navinfo.opentsp.dongfeng.common.result.HttpCommandResultWithData;
import com.navinfo.opentsp.dongfeng.common.result.ReturnCode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登入handler
 */
@Component
public class LoginHandler extends NotValidateTokenAbstractHandler<LoginCommand, HttpCommandResultWithData>
{
    
    @Resource
    private IAuthorityService authorityService;
    
    public LoginHandler()
    {
        super(LoginCommand.class, HttpCommandResultWithData.class);
    }
    
    protected LoginHandler(Class<LoginCommand> commandType, Class<HttpCommandResultWithData> resultType)
    {
        super(commandType, resultType);
    }
    
    @Override
    protected HttpCommandResultWithData businessHandle(LoginCommand command)
    {
        // logger.info("=====  login start  =====");
        HttpCommandResultWithData result = new HttpCommandResultWithData();
        
        try
        {
            result = authorityService.login(command);
        }
        catch (Exception e)
        {
            result.fillResult(ReturnCode.LOGIN_FAIL);
            logger.error("===== businessHandle Exception =====" , e);
        }
        
        return result;
    }
}