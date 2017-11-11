<#if message??>
<div class="row">
    <div class="col-lg-12 text-center">
        <div class="alert alert-success shine"  style="background-color: #995c00; color: white; font-weight: bold; font-size: 15px">
            <button class="close" data-dismiss="alert" style="color: white">
                <i class="ace-icon fa fa-times" style="color: white"></i>
            </button>
            ${message!''}
            <#--<br>
            ${Session.session_user.name!}-->
        </div>
    </div>
</div>
</#if>