package mycity.com.citymanage.config;

/**
 *class Constant
 *@author GuoZhuShu
 * create at 2016/6/7 15:56
 **/
public class Constant {

    /**
     * 请求的服务端接口
     *
     */

//        public static final String NestBase_URL="http://192.168.6.176:8081/nest"; //公司张雨韬接口
//        public static final String NestBase_URL="http://192.168.6.181:8889/nest"; //公司杜率接口
       public static final String NestBase_URL="http://222.171.205.8:8080/nest"; //国裕公司接口
    //  public static final String NestBase_URL="http://222.171.243.185:8070/nest"; //哈尔滨公司外网接口
    //public static final String NestBase_URL="http://192.168.1.150:8080/nest"; //哈尔滨公司内网接口



//        public static final String XinPai_ADD_URL= NestBase_URL+"/app/process/workOrder/add"; //新派添加数据接口
        public static final String XinPai_ADD_URL= NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=addWorkOrder"; //新派添加数据接口
        public static final String XinPai_BaoXiu_URL= NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=addRepair"; //报修接口
//        public static final String XinPai_Photo_URL= NestBase_URL+"/app/process/image"; //新派上传图片接口
        public static final String XinPai_Photo_URL= NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=uploadPicture"; //新派上传图片接口
         public static final String XinPai_User_URL= NestBase_URL+ "/servlet/ProcessWorkOrderServlet?method=queryPeople";//新派中从责任区获得指派人
//        public static final String ARCGIS_MAP_URL="http://115.236.69.243:8399/arcgis/rest/services/shanghai/MapServer"; //arcgis地图接口
        public static final String ARCGIS_ClientId="1eFHW78avlnRUPHm"; //arcgis地图接口ID

//    public static final String ARCGIS_BASE_MAP_URL="http://222.171.205.8:6090/arcgis/rest/services/84底图终版/MapServer";
//    public static final String ARCGIS_MAP_URL="http://222.171.205.8:6090/arcgis/rest/services/LDSS/FeatureServer";
//    public static final String ARCGIS_MAP_URLALL="http://222.171.205.8:6090/arcgis/rest/services/LDBJ/FeatureServer/3";//添加rtu单个图层
//地图显示的url
    public static final String ARCGIS_BASE_MAP_URL="http://222.171.205.8:6090/arcgis/rest/services/dt/MapServer";
  //  public static final String ARCGIS_BASE_MAP_URL="http://222.171.73.107:6080/arcgis/rest/services/dt/MapServer";//哈尔滨公司社区地图服务
    public static final String ARCGIS_MAP_LDBJ_ALL="http://222.171.205.8:6090/arcgis/rest/services/LDBJFW/MapServer";
    public static final String ARCGIS_MAP_LDSS_DANDENG="http://222.171.205.8:6090/arcgis/rest/services/LDSSFW/MapServer/3";
   // public static final String ARCGIS_MAP_LDAPP="http://222.171.205.8:6090/arcgis/rest/services/LDAPP/MapServer";
    public static final String ARCGIS_MAP_LDAPP="http://222.171.243.185:6080/arcgis/rest/services/LDAPP/MapServer";
    public static final String ARCGIS_MAP_DT= "http://222.171.243.185:6080/arcgis/rest/services/84底图终版/MapServer";
//在rtu详情显示的地图
    public static final String ARCGIS_MAP_URLALL="http://222.171.205.8:6090/arcgis/rest/services/LDBJFW/MapServer/3";

//    public static final String ARCGIS_MAP_LDBJ_ALL="http://222.171.205.8:6090/arcgis/rest/services/LDBJ/MapServer";//用来动态添加所有图层
//    public static final String ARsCGIS_MAP_LDSS_DANDENG="http://222.171.205.8:6090/arcgis/rest/services/LDSS/FeatureServer/3";//添加单灯单个图层
//


//    public static final String ARCGIS_MAP_URLALL="http://222.171.205.8:6090/arcgis/rest/services/LDSS/MapServer";
//        public static final String XinPai_CAHXUN_URL= XinPaiBase_URL+"/servlet/ProcessWorkOrderServlet?method=deleteReceipt"; //删除回执
        public static final String XinPai_CAHXUN_URL= NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=queryReceipt"; //查询回执
//        public static final String XinPai_CAHXUN_URL= XinPaiBase_URL+"/servlet/ProcessWorkOrderServlet?method=addReceipt"; //添加修改回执同一个接口
//        public static final String XinPai_DAIBAN_URL= XinPaiBase_URL+"/servlet/ProcessWorkOrderServlet?method=queryProcess"; //回执

        public static final String BAOXIU_RTU_AREA_URL= NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=queryArea";//报修中的rtu区域
        public static final String EQUIPMENT_ALL_URL= NestBase_URL+"/servlet/DeviceRtuServlet?method=queryAllRtu"; //rtu全部列表
        public static final String SHEBEI_AREA_URL= NestBase_URL+"/servlet/DeviceRtuServlet?method=queryArea"; //rtu区域
        public static final String SHEBEI_QUERYAREA_URL= NestBase_URL+"/servlet/DeviceRtuServlet?method=queryAllRtu"; //设备搜索
//        public static final String EQUIPMENT_SINGLE_AREA_URL= XinPaiBase_URL+"/servlet/DeviceRtuServlet?method=queryRtuByAreaId"; //rtu责任区的列表
        public static final String EQUIPMENT_RTU_INFO_URL= NestBase_URL+"/servlet/DeviceRtuServlet?method=queryRtuInfos"; //rtu详情
        public static final String EQUIPMENT_RTU_ZC_URL= NestBase_URL+"/servlet/DeviceRtuServlet?method=measureRtu"; //rtu招测/全招
        public static final String EQUIPMENT_RTU_CLZC_URL= NestBase_URL+"/servlet/DeviceRtuServlet?method=measeureRtuTime"; //策略招测/招测开关灯时间/全招
        public static final String EQUIPMENT_RTU_KGML_URL= NestBase_URL+"/servlet/DeviceRtuServlet?method=sendSwitchControl"; //开关下发命令
        public static final String EQUIPMENT_RTU_CLXF_URL= NestBase_URL+"/servlet/DeviceRtuServlet?method=sendSwitchTime"; //策略下发

    //单灯监控
        public static final String EQUIPMENT_SINGLE_LAMP_URL= NestBase_URL+"/servlet/DeviceRtuServlet?method=getLightMonitorList"; //单灯监控
    //单灯数据
        public static final String EQUIPMENT__LAMP_DATA_URL= NestBase_URL+"/servlet/DeviceRtuServlet?method=getLightData"; //单灯数据


        public static final String Daiban_history_URL= NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=getComboBoxData"; //历史list列表数据接口
        public static final String XinPai_URL= NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=AddComboBoxData"; //新派list列表数据接口
        public static final String LOGIN_URL = NestBase_URL+"/app/user/login"; //登录接口
//        public static final String LOGIN_URL = "http://192.168.6.2:4567/nestheb/servlet/ProcessWorkOrderServlet";
        public static final String WAITDEAL_URL = NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=queryProcess";//待办、历史接口
        public static final String WAITDEAL_DETAILS_URL = NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=getWorkOrderInfo";//待办详情
        public static final String WAITDEAL_DETAILS_UPLOAD_IMG_URL = NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=uploadOperateImage";//待办详情图片上传
        public static final String WAITDEAL_COMMIT_URL = NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=operateWorkOrder";//待办详情提交操作说明
        public static final String WAITDEAL_ADDPRECEIPT_URL = NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=addReceipt";//添加回执
        public static final String WAITDEAL_CHECKRECEIPT_URL = NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=queryReceipt";//查看回执
        public static final String WAITDEAL_RECEIPT_DETAIL_URL = NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=gotReceiptDetail";//回执详情
        public static final String WAITDEAL_LIUCHEGN_URL = NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=queryProcessFlow";//查看流程

        public static final String BASE_URL=NestBase_URL+"/servlet/WaitDealServlet";
        public static final String ADDPGUPLOADPIC="addPgUploadPic";//手机端app添加图片的标示
        public static final String imgUpLoad_URL=NestBase_URL+"/servlet/FileImageUploadServlet?method=doPost&imgType=1";
        public static final String REPAIR_URL=NestBase_URL+"/servlet/WaitDealServlet?method=takeRepair";
        public static final String TAKEDETAIL_URL=NestBase_URL+"/servlet/WaitDealServlet?method=takeDeatails";
        public static final String TAKERECEIPT_URL=NestBase_URL+"/servlet/WaitDealServlet?method=takeRecipt";
        public static final String RECEIPTDETAIL_URL=NestBase_URL+"/servlet/WaitDealServlet?method=gotReceiptInfo";


    //环境
    public static final String ENVIRONMENT_URL=NestBase_URL+"/servlet/EnviroInfoServlet?method=gotEnviroInfo";//环境监测仪全部查询
    public static final String ENVIRONMENT_BYID_URL=NestBase_URL+"/servlet/EnviroInfoServlet?method=gotEnviById";//环境检测仪按ID进行查询
    public static final String ENVIRONMENT_ZHAOCE_URL=NestBase_URL+"/servlet/EnviroInfoServlet?method=sendEvnStatus";//环境招测
    //单灯
    public static final String BULB_BYFIEL_URL=NestBase_URL+"/servlet/EnviroInfoServlet?method=gotBulbByFiel";//路灯按外业流水号进行查询
    //水尺
    public static final String WATER_RULER_URL=NestBase_URL+"/servlet/EnviroInfoServlet?method=gotWaterRuleInfo";//水尺全部查询接口
    public static final String WATER_RULER_BYID_URL=NestBase_URL+"/servlet/EnviroInfoServlet?method=gotWaterRuleById";//水尺按ID进行查询接口
    public static final String WATER_RULER_ZHAOCE_URL=NestBase_URL+"/servlet/EnviroInfoServlet?method=sendRuleLength";//水尺招测
    public static final String NOTICE_URL=NestBase_URL+"/servlet/EnviroInfoServlet?method=gotNoticeInfo";//公告
    public static final String NOTICE_DETAIL_URL=NestBase_URL+"/servlet/EnviroInfoServlet?method=gotNoticeById";//公告详情
    //稽查
    public static final String JICHA_URL=NestBase_URL+"/servlet/ProcessWorkOrderServlet?method=queryCheckInfo";//稽查
    public static final String GONGGAO_URL = NestBase_URL + "/servlet/EnviroInfoServlet?method=gotAdverInfo"; //公告
    /**
     * 待办 ：待办  0   历史 1
     * @author Administrator
     *
     */
    public static final class WaitDealStatus{
        public static final int Status_WAITDEAL= 0;
        public static final int Status_HISTORY= 1;

    }

    /**
     *  界面数据回调
     *  add by hongbing
     */
    public static final class RESULT_CODE{

        /**
         * 更新用户信息
         */
        public static final int REQUEST_CODE_UPDATA_USER = 0x001;
        /**
         * 拍照成功
         */
        public static final int RESULT_CODE_TAKE_PHOTO = 0x020;
        /**
         * 裁剪成功
         */
        public static final int RESULT_CODE_CROP_SUCCESS = 0x021;
        /**
         * 从相册中选择
         */
        public static final int RESULT_CODE_SEL_ALBUM = 0x022;
        /**
         * 从相册中选择，裁剪成功
         */
        public static final int RESULT_CODE_GETIMAGE_BYSDCARD = 0x023;
    }

    /**
     * 设备中的界面类型
     *
     */
    public  static final class EquipmentStatus{
        public static final String STATUS_ALL = "0";
        public static final String STATUS_CITY_ESAT = "1";
        public static final String STATUS_CITY_SOUTH = "2";
        public static final String STATUS_CITY_WEST = "3";
        public static final String STATUS_CITY_NORTH = "4";
        public static final String STATUS_LANGSCAPE = "5";
    }

    public static String gonggaoContent;
    public static String gonggaoTitle;
    public static String gonggaoDate;
}
