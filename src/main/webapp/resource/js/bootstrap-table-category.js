//以tag标签页面为主
function InitMainCategoryTable() {
    $("#back_category_table").bootstrapTable({
        url: "/category/bc/",           //请求后台的URL（*）
        dataType: "json",
        //此间是与client不一样的地方=======================开始
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
        detailView: false,              //是否显示父子表

        pageNumber: 1,                  //初始化加载第一页，默认第一页,并记录
        pageSize: 10,                   //每页的记录行数（*）
        pageList: [5, 10, 20, 30, 50],  //可供选择的每页的行数（*）

        smartDisplay: true,             //true时会自动选择显示每页可选择的行数

        minimumCountColumns: 2,         //最少允许的列数
        clickToSelect: true,            //是否启用点击选中行

        height: 500,                    //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "category_name",      //每一行的唯一标识，一般为主键列

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
            {checkbox: 'false', title: ''},
            {field: 'category_name', title: '名称', sortable: true},
            {field: 'category_content', title: '简述', sortable: true},
            //{fiele: 'article_count', title: '文章数量'}, //暂时不添加，sql查询语句未完善
            {field: 'category_id', tittle: '操作', width: 120, align: 'center', formatter: actionFormatter}
        ],
        onDblClickRow: function (row, $element) {
            //alert(row.tag_id);
            //alert(row.tag_cid);           //可以取出未在行中显示的值

            //可添加点击行弹出编辑框的事件
        },
    })
}

function actionFormatter(value, row, index) {
    var id = value;
    var result = "";
    result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"beforOpenEditModal('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"deleteByIds('" + id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;
}

function openAddModal() {
    $("#addCategoryModal").modal('show');
}

//新增标签
function addCategory(){
    var param = $("#addCategoryForm").serialize();
    //debugger;//用于前端调试
    $("#conf_add").attr("onclick","addCategory()");
    $.ajax({
        url:"/category/",
        method:"post",
        data:param+"&_method=PUT",
        dataType:"json",
        success:function(data){
            //$("#testJson").empty();
            //$("#testJson").append(JSON.stringify(data));

            document.getElementById("tipContent").innerText=data.extend.msgInfo;
            $("#Tip").modal('show');
            $("#addCategoryModal").modal('hide');
            $("#back_category_table").bootstrapTable('refresh');
            resetAddModal();
        },
        error:function(){
            document.getElementById("tipContent").innerText="新增失败";
            $("#Tip").modal('show');
        }
    });
}

//重置新增表单，清空表单中已写信息
function resetAddModal(){
    document.getElementById("addCategoryForm").reset();
    $("#addCategoryModal").modal('hide');
}

function beforOpenEditModal() {
    setTimeout(function () {
        openEditModal();
    },1000);
}

function openEditModal() {
    var rows = $("#back_category_table").bootstrapTable('getSelections');
    if(rows.length!=1){
        document.getElementById("tipContent").innerText="请选择一行数据";
        $("#Tip").modal('show');
    }
    else{
        var row = rows[0];
        $('#edit_input').val(row.category_id);
        $('#edit_input1').val(row.category_name);
        $('#edit_input2').val(row.category_content);
        $("#editCategoryModal").modal("show");
    }
}

function editCategory(){
    var param = $("#editCategoryForm").serialize();
    //debugger;//用于前端调试
    $.ajax({
        url:"/category/"+1,
        method:"post",
        data:param+"&_method=POST",
        dataType:"json",
        success:function(data){
            //$("#testJson").empty();
            //$("#testJson").append(JSON.stringify(data));

            document.getElementById("tipContent").innerText=data.extend.msgInfo;
            $("#Tip").modal('show');
            $("#editCategoryModal").modal("hide");
            $("#back_category_table").bootstrapTable('refresh');
        },
        error:function(){
            document.getElementById("tipContent").innerText="修改失败";
            $("#Tip").modal('show');
        }
    });
}

//实现删除数据的方法
function deleteCategorys() {
    var ids = "";//得到用户选择的数据的ID
    var rows = $("#back_category_table").bootstrapTable('getSelections');
    for (var i = 0; i < rows.length; i++) {
        ids += rows[i].category_id + ',';
    }
    ids = ids.substring(0, ids.length - 1);

    //$("#testJson").empty();
    //$("#testJson").append(JSON.stringify(ids));

    deleteByIds(ids);
}

function deleteByIds(ids) {
    $.ajax({
        url:"/category/",
        method:"post",
        data:{delIds:ids,_method:"DELETE"},
        dataType:"json",
        success:function (data) {
            document.getElementById("tipContent").innerText=data.extend.msgInfo;
            $("#Tip").modal('show');
            $("#back_category_table").bootstrapTable('refresh');
        }
    })
}