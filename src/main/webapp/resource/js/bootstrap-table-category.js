function InitMainTagTable() {
    $("#back_tag_table").bootstrapTable({
        url: "/tag/",                   //请求后台的URL（*）
        dataType: "json",
        //此间是与client不一样的地方=======================开始
        contentType: "application/x-www-form-urlencoded",
        sidePagination: "server",       //分页方式：client客户端分页，server服务端分页（*）
        //如果使用client是否要返回一个json文件，为什么使用client无法显示数据
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
        uniqueId: "tag_name",           //每一行的唯一标识，一般为主键列

        //queryParamsType:"",           //queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
        //设置为 ''在这种情况下传给服务器的参数为：pageSize,pageNumber */
        //get请求的参数全部保存在queryParams参数  //(bootstrap 封装好的)
        queryParams: function (params) {//得到查询的参数
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                /*rows: params.limit,                       //页面大小
                page: (params.offset / params.limit) + 1,   //页码
                sort: params.sort,                          //排序列名
                sortOrder: "desc"*/                         //排位命令（desc，asc）
                limit: this.limit,     //页面大小
                offset: this.offset,   //页码
                pageNumber: this.pageNumber,
                pageSize: this.pageSize
            };
            return temp;
        },
        columns: [
            {checkbox: 'false', title: ''},
            {field: 'tag_name', title: '标签', sortable: true},
            {field: 'tag_content', title: '简述', sortable: true},
            {field: 'category_name', title: '类别', sortable: true},
            //{fiele: 'article_count', title: '文章数量'}, //暂时不添加，sql查询语句未完善
            {field: 'tag_id', tittle: '操作', width: 120, align: 'center', formatter: actionFormatter}
        ],
        /*responseHandler:function (res) {
            //在ajax获取到数据，渲染表格之前，修改数据源，后端直接返回pageInfo数据时使用
            var nres = [];
            nres.push({total:res.pageInfo.total,rows:res.pageInfo.list});
            return nres[0];
        }*/
        onDblClickRow: function (row, $element) {
            //alert(row.tag_id);
            //alert(row.tag_cid);           //可以取出未在行中显示的值

            //可添加点击行弹出编辑框的事件
        },
    })
}

function addCategory() {
    $.ajax({
        url:"/category/",
        dataType: "json",
        type:"get",
        //method: "GET",
        data:{_method:"GET"},
        success:function (data) {
            for (var i=0;i<data.length;i++){
                $("#add_input3").append("<option value='"+data[i].category_id+"'>"+data[i].category_name+"</option>");
                $("#edit_input3").append("<option value='"+data[i].category_id+"'>"+data[i].category_name+"</option>");
            }
        }
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
    $("#addTagModal").modal('show');
}

//新增标签
function addTag(){
    var param = $("#addTagForm").serialize();
    //debugger;//用于前端调试
    $("#conf_add").attr("onclick","addTag()");
    $.ajax({
        url:"/tag/",
        method:"post",
        data:param+"&_method=PUT",
        dataType:"json",
        success:function(data){
            //$("#testJson").empty();
            //$("#testJson").append(JSON.stringify(data));

            document.getElementById("tipContent").innerText=data.extend.msgInfo;
            $("#Tip").modal('show');
            $("#addTagModal").modal('hide');
            $("#back_tag_table").bootstrapTable('refresh');
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
    document.getElementById("addTagForm").reset();
    //$("#addTipForm")[0].reset();//JQuery中没有reset方法，$('#myform')[0].reset()也就是通过调用 DOM 中的reset方法来重置表单。

    //报错的最主要的原因是id的值写错，但是如果是null值报出以下错误，可以用下面的解决方案
    //Uncaught TypeError: Cannot read property 'reset' of undefined
    //var form = $("#("#addTagForm")[0]== undefined ? '' : $("#("#addTipForm")[0].reset();

    $("#addTagModal").modal('hide');

    // <textarea> 不能是自闭环
}

function beforOpenEditModal() {
    //使模态框再复选框勾选后弹出，勾选和弹出有时间差，一般是弹出(触发方法在前)
    //但是设置了延时触发也有另一个问题：当该行已点击时，点击图标，因为延时，改行在方法前为未选，导致操作偏离实际意图
    //在点击时清除其他的选择，并保证点击所在的行被选中？？？
    setTimeout(function () {
        openEditModal();
    },1000);
}

function openEditModal() {
    var rows = $("#back_tag_table").bootstrapTable('getSelections');
    if(rows.length!=1){
        document.getElementById("tipContent").innerText="请选择一行数据";
        $("#Tip").modal('show');
    }
    else{
        var row = rows[0];
        $('#edit_input').val(row.tag_id);
        $('#edit_input1').val(row.tag_name);
        $('#edit_input2').val(row.tag_content);
        $('#edit_input3').val(row.tag_cid);
        $("#editTagModal").modal("show");
    }
}

function editTag(){
    var param = $("#editTagForm").serialize();
    //debugger;//用于前端调试
    $.ajax({
        url:"/tag/"+1,
        method:"post",
        data:param+"&_method=POST",
        dataType:"json",
        success:function(data){
            //$("#testJson").empty();
            //$("#testJson").append(JSON.stringify(data));

            document.getElementById("tipContent").innerText=data.extend.msgInfo;
            $("#Tip").modal('show');
            $("#editTagModal").modal("hide");
            $("#back_tag_table").bootstrapTable('refresh');
        },
        error:function(){
            document.getElementById("tipContent").innerText="修改失败";
            $("#Tip").modal('show');
        }
    });
}

//实现删除数据的方法
function deleteTags() {
    var ids = "";//得到用户选择的数据的ID
    var rows = $("#back_tag_table").bootstrapTable('getSelections');
    for (var i = 0; i < rows.length; i++) {
        ids += rows[i].tag_id + ',';
    }
    ids = ids.substring(0, ids.length - 1);

    //$("#testJson").empty();
    //$("#testJson").append(JSON.stringify(ids));

    deleteByIds(ids);
}

function deleteByIds(ids) {
    $.ajax({
        url:"/tag/",
        method:"post",
        data:{delIds:ids,_method:"DELETE"},
        dataType:"json",
        success:function (data) {
            document.getElementById("tipContent").innerText=data.extend.msgInfo;
            $("#Tip").modal('show');
            $("#back_tag_table").bootstrapTable('refresh');
        }
    })
}