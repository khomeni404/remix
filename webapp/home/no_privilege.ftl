<#import "../taim_template/taims_layout.ftl" as layout>
<@layout.taims_layout   '${(title)!}'>
    <#assign ctx = rc.getContextPath()/>

<div class="row">
    <div class="col-lg-12 text-center">
        <div class="alert  <#--alert-danger-->">
            <button class="close" data-dismiss="alert">
                <i class="ace-icon fa fa-times"></i>
            </button>
            <b style="font-weight: bolder; font-size: 14px">${message!}</b>
            <hr />
            <img src="../resources/images/no_privilege.gif" width="" alt="">
            <hr />
            <h4 class="lighter smaller" style="font-weight: bolder">
               Don't Worry. Please ensure your CASM
               Privilege <i class="ace-icon fa fa-wrench icon-animated-wrench bigger-125"></i>
                settings !
            </h4>

        </div>
    </div>

    <div class="col-lg-12 text-center">
        <#--<img src="../resources/images/no_privilege.gif" width="" alt="">-->
    </div>
</div>
</@layout.taims_layout>