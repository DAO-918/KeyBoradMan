var $table;
//初始化bootstrap-table的内容
function InitMainArticleTable () {

    //记录页面bootstrap-table全局变量$table，方便应用
    //var queryUrl = '/TestUser/FindWithPager?rnd=' + Math.random();
    //请求方式（*）

    $("#back_article_table").bootstrapTable({

        //type: "GET",
        url: "/bcarticle",                //请求后台的URL（*）
        //data: "pageNo=" + 1,
        dataType:"json",

        //此间是与client不一样的地方=======================开始
        contentType : "application/x-www-form-urlencoded",
        sidePagination : "server",      //分页方式：client客户端分页，server服务端分页（*）
        //如果使用client是否要返回一个json文件，为什么使用client无法显示数据
        method:"GET",                   //请求方式（*）
        toolbar: '#toolbar',          //工具按钮用哪个容器
        search: false,                  //是否显示表格搜索
        showFooter : false,             //显示底部，默认不显示
        //sortName : "art_id",
        sortable: false,                 //是否启用排序
        sortOrder: "asc",               //排序方式
        //此间是与client不一样的地方=======================结束
        searchOnEnterKey : true,
        strictSearch: true,

        striped: true,                  //是否显示行间隔色
        cache: true,                   //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        locale:"zh-CN",                 //中文支持
        pagination: true,               //是否显示分页（*）
        showPaginationSwitch : true,    //显示切换分页

        showFullscreen : false,         //显示全屏
        showHeader : true,              //显示头部，默认显示
        showExport : true,              //显示导出
        showColumns: true,              //是否显示所有的列（选择显示的列）
        showRefresh: true,              //是否显示刷新按钮
        sortable : true,                //是否启用排序
        showToggle: true,               //是否显示详细视图和列表视图的切换按钮
        cardView: false,                //是否显示详细视图
        detailView: false,              //是否显示父子表

        pageNumber: 1,                  //初始化加载第一页，默认第一页,并记录
        pageSize: 10,                    //每页的记录行数（*）
        pageList: [5, 10, 20, 30, 50],  //可供选择的每页的行数（*）

        smartDisplay: true,

        minimumCountColumns: 2,         //最少允许的列数
        clickToSelect: true,            //是否启用点击选中行

        height: 500,                    //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "art_id",             //每一行的唯一标识，一般为主键列

        //queryParamsType:"",            //queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
        //设置为 ''在这种情况下传给服务器的参数为：pageSize,pageNumber */
        //get请求的参数全部保存在queryParams参数  //(bootstrap 封装好的)
        queryParams : function (params) {//得到查询的参数
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                /*rows: params.limit,                         //页面大小
                page: (params.offset / params.limit) + 1,   //页码
                sort: params.sort,                          //排序列名
                sortOrder: "desc"*/                         //排位命令（desc，asc）
                limit : this.limit,     //页面大小
                offset : this.offset,   //页码
                pageNumber : this.pageNumber,
                pageSize : this.pageSize
            };
            return temp;
        },
        columns: [
            {checkbox: 'false',title:''},
            //{field: 'art_id', title: '编号'},
            {field: 'user_name', title: '作者',sortable: true},
            {field: 'art_title', title: '标题',sortable: true},
            {field: 'tag_name', title: '标签',sortable: true},
            {field: 'art_com_num', title: '评论数',sortable: true},
            {field: 'art_hot_num', title: '浏览量',sortable: true},
            {field: 'art_like_num', title: '点赞数',sortable: true},
            {field: 'art_create_time', title: '发表时间',sortable: true},
            {field:'art_id',tittle:'操作',width:120,align:'center',formatter:actionFormatter}
        ],
        /*responseHandler:function (res) {
            //在ajax获取到数据，渲染表格之前，修改数据源
            var nres = [];
            nres.push({total:res.pageInfo.total,rows:res.pageInfo.list});
            return nres[0];
        }*/
        onDblClickRow: function (row, $element) {
            alert(row.art_id);
           //var id = row.ID;
           //EditViewById(id, 'view');
        },
    })

}

function actionFormatter(value, row, index) {
    var id = value;
    var result = "";
    result += "<a href='javascript:;' class='btn btn-xs green' onclick=\"EditViewById('" + id + "', view='view')\" title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"EditViewById('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"DeleteByIds('" + id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;
}

//连接字段格式化
function linkFormatter(value, row, index) {
    return "<a href='" + value + "' title='单击打开连接' target='_blank'>" + value + "</a>";
}
//Email字段格式化
function emailFormatter(value, row, index) {
    return "<a href='mailto:" + value + "' title='单击打开连接'>" + value + "</a>";
}
//性别字段格式化
function sexFormatter(value) {
    if (value == "女") { color = 'Red'; }
    else if (value == "男") { color = 'Green'; }
    else { color = 'Yellow'; }

    return '<div  style="color: ' + color + '">' + value + '</div>';
}
