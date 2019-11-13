//以tag标签页面为主
function InitMainCommentTable() {
    $("#back_comment_table").bootstrapTable({
        url: "/comment/bc/",           //请求后台的URL（*）
        dataType: "json",
        //此间是与client不一样的地方=======================开始omment
        contentType: "application/x-www-form-urlencoded",
        sidePagination: "server",       //分页方式：client客户端分页，server服务端分页（*）
        method: "GET",                  //请求方式（*）
        toolbar: '#toolbar',            //工具按钮用哪个容器
        search: false,                  //是否显示表格搜索
        showFooter: false,              //显示底部，默认不显示
        //sortName : "art_id",
        sortable: false,                //是否启用排序
        sortOrder: "asc",               //排序方式
        //此间是与client不一样的地方=======================结束
        searchOnEnterKey: true,
        strictSearch: true,

        striped: true,                  //是否显示行间隔色
        cache: false,                   //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        locale: "zh-CN",                //中文支持
        pagination: true,               //是否显示分页（*）
        showPaginationSwitch: true,     //显示切换分页

        showFullscreen: false,          //显示全屏
        showHeader: true,               //显示头部，默认显示
        showExport: true,               //显示导出
        showColumns: true,              //是否显示所有的列（选择显示的列）
        showRefresh: true,              //是否显示刷新按钮
        sortable: true,                 //是否启用排序
        showToggle: true,               //是否显示详细视图和列表视图的切换按钮
        cardView: false,                //是否显示详细视图
        detailView: true,              //是否显示父子表

        pageNumber: 1,                  //初始化加载第一页，默认第一页,并记录
        pageSize: 10,                   //每页的记录行数（*）
        pageList: [5, 10, 20, 30, 50],  //可供选择的每页的行数（*）

        smartDisplay: true,             //true时会自动选择显示每页可选择的行数

        minimumCountColumns: 2,         //最少允许的列数
        clickToSelect: true,            //是否启用点击选中行

        height: 500,                    //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "comment_name",       //每一行的唯一标识，一般为主键列

        showExport: true,               //是否显示导出
        exportDataType: "basic",        //basic', 'all', 'selected'

        queryParams: function (params) {//得到查询的参数
            var temp = {
                limit: this.limit,     //页面大小
                offset: this.offset,   //页码
                pageNumber: this.pageNumber,
                pageSize: this.pageSize
            };
            return temp;
        },
        columns: [
            {field: 'art_title', title: '文章标题', },
            {field: 'user_name', title: '评论者', },
            {field: 'com_content', title: '评论正文', },
            {field: 'com_like', title: '点赞数', },
            {field: 'com_time', title: '评论时间',
                formatter: function (value, row, index) {return changeDateFormat(value)}},
            {field: 'com_id', tittle: '操作', width: 120, align: 'center', formatter: actionFormatter1}
        ],
        onDblClickRow: function (row, $element) {
            //alert(row.tag_id);
            //alert(row.tag_cid);           //可以取出未在行中显示的值
        },
        //注册加载子表的事件。注意下这里的三个参数！
        onExpandRow: function (index, row, $detail) {
            InitSubTable(index, row, $detail);
        }
    });
}

function InitSubTable(index, row, $detail) {
    var parentid = row.com_id;
    var cur_table = $detail.html('<table></table>').find('table');
    $(cur_table).bootstrapTable({
        url: "/multi/bcid/"+parentid,
        method: 'get',
        contentType: "application/x-www-form-urlencoded",
        //contentType: 'application/json;charset=UTF-8',
        dataType: 'json',
        //queryParams: {id: parentid},
        //ajaxOptions: {id: parentid},
        clickToSelect: true,
        detailView: false,//是否启用父子表
        uniqueId: "id",
        pageSize: 10,
        pageList: [10, 25],
        columns: [
            {field: 'user_name', title: '评论者', },
            {field: 'com_multi_content', title: '评论正文', },
            {field: 'com_multi_like', title: '点赞数', },
            {field: 'com_multi_time', title: '评论时间',
                formatter: function (value, row, index) {return changeDateFormat(value)}},
            {field: 'com_multi_id', tittle: '操作', width: 120, align: 'center', formatter: actionFormatter2}
        ],
        //无线循环取子表，直到子表里面没有记录
        /*onExpandRow: function (index, row, $detail) {
            InitSubTable(index, row, $detail);
        }*/
    });
}

function actionFormatter1(value, row, index) {
    var id = value;
    var result = "";
    // result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"\" title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"deleteByIds1('" + row.com_id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;
}
function actionFormatter2(value, row, index) {
    var id = value;
    var result = "";
    // result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"\" title='查看'><span class='glyphicon glyphicon-search'></span></a>";
    result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"deleteByIds2('" + row.com_multi_id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;
}
//为完成判断一级评论下是否有多级评论
function deleteByIds1(ids) {
    $.ajax({
        url:"/comment/",
        method:"post",
        data:{delIds:ids,_method:"DELETE"},
        dataType:"json",
        success:function (data) {
            toastr.success(data.extend.msgInfo)
            //document.getElementById("tipContent").innerText=data.extend.msgInfo;
            //$("#Tip").modal('show');
            $("#back_comment_table").bootstrapTable('refresh');
        }
    })
}
function deleteByIds2(ids) {
    $.ajax({
        url:"/multi/",
        method:"post",
        data:{delIds:ids,_method:"DELETE"},
        dataType:"json",
        success:function (data) {
            toastr.success(data.extend.msgInfo)
            //document.getElementById("tipContent").innerText=data.extend.msgInfo;
            //$("#Tip").modal('show');
            $("#back_comment_table").bootstrapTable('refresh');
        }
    })
}

function changeDateFormat(cellval) {
    var dateVal = cellval + "";
    if (cellval != null) {
        var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
        return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;    }
}
