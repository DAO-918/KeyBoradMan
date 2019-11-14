function addCategory() {
    $.ajax({
        url:"/category/",
        dataType: "json",
        type:"get",
        success:function (data) {
            for (var i=0;i<data.length;i++){
                $("#add_input5").append("<option value='"+data[i].category_id+"'>"+data[i].category_name+"</option>");
            }
        }
    })
}

function addArticle_tag() {
    $.ajax({
        url:"/tag/listTag/",
        dataType: "json",
        type:"get",
        success:function (data) {
            for (var i=0;i<data.length;i++){
                $("#add_input4").append("<option value='"+data[i].tag_id+"'>"+data[i].tag_name+"</option>");
            }
        }
    })
}

