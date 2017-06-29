package com.koou.product.wechat.constant;

public class MsgConstant {
	/**
	 * 微信请求及返回类型
	 */
	// 返回消息类型：文本   
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    // 返回消息类型：音乐        
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
    // 返回消息类型：图文    
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";
    // 请求消息类型：文本 
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";
    // 请求消息类型：图片        
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
    // 请求消息类型：链接    
    public static final String REQ_MESSAGE_TYPE_LINK = "link";
    // 请求消息类型：地理位置   
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
    // 请求消息类型：视频    
    public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
    // 请求消息类型：语音    
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
    // 请求消息类型：推送    
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";
    // 事件类型：subscribe(订阅)    
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    // 事件类型：unsubscribe(取消订阅)    
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    // 事件类型：CLICK(自定义菜单点击事件)    
    public static final String EVENT_TYPE_CLICK = "CLICK";
    // 事件类型：VIEW(自定义菜单点击跳转链接事件)    
    public static final String EVENT_TYPE_VIEW = "VIEW";
    // 事件类型：LOCATION(自定义菜单上传地理位置事件)    
    public static final String EVENT_TYPE_LOCATION = "LOCATION";
    // 事件类型：SCAN(用户已关注事件推送)    
    public static final String EVENT_TYPE_SCAN = "SCAN";
    // 事件类型：TEMPLATESENDJOBFINISH(发送模板消息推送结果事件)    
    public static final String EVENT_TYPE_TEMPLATE = "TEMPLATESENDJOBFINISH";
    /**
     * 微信签名验证
     */
	//微信加密签名
	public static final String REQ_MESSAGE_CHECK_SIGNATURE = "signature";
	//时间戳 
	public static final String REQ_MESSAGE_CHECK_TIMESTAMEP ="timestamp";
	//随机数 
	public static final String REQ_MESSAGE_CHECK_NONCE = "nonce";
	//随机字符串 
	public static final String REQ_MESSAGE_CHECK_ECHOSTR = "echostr";
    // 封装请求信息对象   
    public static final String REQ_MESSAGE_TEMPORARY_MSGOBJECT = "msgObj";
    /**
     * 数据库相关静态数据
     */
    //关键字配置表中图文动作
    public static final int DB_KEYWOED_ACTIONTYPY_NWES = 2;
    //关键字配置表中文本动作
    public static final int DB_KEYWOED_ACTIONTYPY_TEXT = 3;
    //关键字配置表中目录动作
    public static final int DB_KEYWOED_ACTIONTYPY_MENU = 1;
    //索引字配置表中图文动作
    public static final int DB_INDEXWOED_ACTIONTYPY_NWES = 2;
    //索引字配置表中文本动作
    public static final int DB_INDEXWOED_ACTIONTYPY_TEXT = 3;
    //索引字配置表中目录动作
    public static final int DB_INDEXWOED_ACTIONTYPY_MENU = 1;
    //异常配置表中图文动作
    public static final int DB_ERRORINFO_ACTIONTYPY_NWES = 2;
    //异常字配置表中文本动作
    public static final int DB_ERRORINFO_ACTIONTYPY_TEXT = 3;
    //异常字配置表中目录动作
    public static final int DB_ERRORINFO_ACTIONTYPY_MENU = 1;
    //导航菜单类型为标准服务
    public static final int DB_NAVIGATION_TYPE_SERVICE = 0;
    //导航菜单类型为目录
    public static final int DB_NAVIGATION_TYPE_MENU = 1;
    //导航菜单类型为图文消息
    public static final int DB_NAVIGATION_TYPE_NEWS= 2;
    //导航菜单类型为文本消息
    public static final int DB_NAVIGATION_TYPE_TEXT= 3;
    //导航菜单类型为人工客服
    public static final int DB_NAVIGATION_TYPE_HUMAN= 4;
    //导航菜单不需要绑定
    public static final int DB_NAVIGATION_NUNEEDBIND= 0;
    /**
     * 错误信息代码
     */
    //未识别图片
    public static final String ERRCODE_UNRESOLVEDIMAGE= "unresolvedImage";
    //未识别链接
    public static final String ERRCODE_UNRESOLVEDLINK= "unresolvedLink";
    //未识别地址
    public static final String ERRCODE_UNRESOLVEDLOCATION= "unresolvedLocation";
    //未识别语音
    public static final String ERRCODE_UNRESOLVEDVOICE= "unresolvedVoice";
    //未识别视频
    public static final String ERRCODE_UNRESOLVEDVIDEO= "unresolvedVideo";
    //机器人头
    public static final String ERRCODE_REBOTHEAD= "rebotHead";
    //机器人尾
    public static final String ERRCODE_REBOTTAIL= "rebotTail";
    //未识别语义（机器人和语义表都处理不了）
    public static final String ERRCODE_UNSEMANTEME= "unsemanteme";
    //未绑定
    public static final String ERRCODE_UNBIND= "unbind";
    //关注
    public static final String ERRCODE_SUBSCRIBE= "subscribe";
    //请求标准服务失败
    public static final String ERRCODE_REQUESTCATALOGFAIL= "requestCatalogFail";
    //排队队列长度
    public static final String ERRCODE_CANNOTNAVI= "cannotNavi";
    //队伍已满
    public static final String ERRCODE_FULLQ= "queueIsFull";
    //马上能被服务
    public static final String ERRCODE_TOBESERVE= "firstServe";
    //不在服务时间段内（人工客服）
    public static final String ERRCODE_NOTSERVICETIME= "notServiceTime";
    //休息时间（人工客服）
    public static final String ERRCODE_INREST = "resttime";
    /**
     * 目录上下文信息
     */
    //微信号
    public static final String MENU_CONTEXT_WEIXINKEY = "weixinKey";
    //上下文创建时间
    public static final String MENU_CONTEXT_CREATETIME = "contextCreateTime";
    //上下文的状态
    public static final String MENU_CONTEXT_STATE = "oneLevelMenuState";
    
    /**
     * 标准服务返回类型
     */
    //单个参数
    public static final String WS_RESULTXML_MSGTYPE_SINGLE = "Single";
    //多个参数
    public static final String WS_RESULTXML_MSGTYPE_MULTI = "Multi";
    
    /**
     * 服务请求方式
     */ 
    //点击微信菜单
    public static final int LOG_REQUEST_BY_MENU = 0;
    //回复导航菜单
    public static final int LOG_REQUEST_BY_REPLY = 1;
    
    /**
     * 关注、取消关注
     */ 
    //关注类型
    public static final int LOG_SUBSCRIBE = 1;
    //取消关注
    public static final int LOG_UNSUBSCRIBE = 0;
    
    /**
     * 未识别语义类型
     */
    //文本
    public static final int LOG_UNRECOGNIZE_TEXT = 1;
    //图片    
    public static final int LOG_UNRECOGNIZE_IMAGE = 2;
    //地址    
    public static final int LOG_UNRECOGNIZE_LOCATION = 3;
    //链接    
    public static final int LOG_UNRECOGNIZE_LINK = 4;
    //事件    
    public static final int LOG_UNRECOGNIZE_EVENT = 5;
    //语音    
    public static final int LOG_UNRECOGNIZE_VOICE = 6;
    //视频    
    public static final int LOG_UNRECOGNIZE_VEDIO = 7;
    
    /**
     * 微信账号绑定的状态
     * =0表示冻结（取消关注了）
     * =1表示关注未绑定
     * =2表示关注且绑定了
     */
    public static final int ACC_STATUS_0 = 0;
    public static final int ACC_STATUS_1 = 1;
    public static final int ACC_STATUS_2 = 2;
    
    /**
     * 微信账号发送模板消息
     * =0未发送
     * =1发送成功
     * =2发送失败
     * =3送达失败
     */
    public static final int TM_MSG_SEND_NO = 0;
    public static final int TM_MSG_SEND_OK = 1;
    public static final int TM_MSG_SEND_FAIL = 2;
    public static final int TM_MSG_SEND_EVENDFAIL = 3;
    
    /**
     * 群发信息类型
     * mpnews图文消息
     * 
     */
    public static final String MASS_MSGTYPE_MPNEWS = "mpnews";
    
    //机器人上下文
    public static final int CONTEXT_ROBOT =-1;
    //人工客服上下文
    public static final int CONTEXT_HUMANKF = -2;
    
    //用户结束会话
    public static final int SESS_END_BY_CUST = 1;
    //用户发送消息
    public static final int MSG_SEND_BY_CUST = 1;
    
	//系统消息：用户退出
	public static final String MSG_TYPE_ENDSESS = "0";
	//系统消息：新建立会话
	public static final String MSG_TYPE_NEWSESS = "1";
	//普通消息
	public static final String MSG_TYPE_NOMAL = "2";
}
