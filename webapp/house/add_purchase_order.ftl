<#import "../taim_template/taims_layout.ftl" as layout>
<@layout.taims_layout  "${(title)!}" >
    <#import "/spring.ftl" as spring/>
    <#assign ctx = rc.getContextPath()/>
    <#assign order = POrder/>

<div class="row">
    <form id="incident-form" action="${ctx}/house/saveOrder.ibbl" method="POST" class="form-horizontal"
          role="form">

        <div class="col-xs-6">
            <#--<#if order.mModel??>-->
                <#--<@spring.formHiddenInput  "POrder.mModel.id"/>-->
            <#--<span class="form-control">${order.mModel.info()!'N/A'}</span>-->
            <#--<#else >-->
                <div class="form-group">
                    <label class="col-sm-4 control-label no-padding-right" for="incident-type"> Model Name / No</label>
                    <div class="col-sm-8">
                        <@spring.formSingleSelect "POrder.mModel.id", modelMap!,  "class='form-control select2-single' data-placeholder='Choose a Model...'"/>
                        <@spring.showErrors " & ", "err-msg" />
                    </div>
                </div>
            <#--</#if>-->

            <div class="form-group">
                <label class="col-sm-4 control-label no-padding-right" for="refNo"> Order No </label>
                <div class="col-sm-8">
                    <@spring.formInput  "POrder.orderNo" "class='form-control se-num'" />
                    <@spring.showErrors " & ", "err-msg" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-4 control-label no-padding-right" for="incident-type"> Order QTY</label>
                <div class="col-sm-8">
                    <@spring.formInput  "POrder.qty" "class='form-control se-num'" />
                    <@spring.showErrors " & ", "err-msg" />
                </div>
            </div>


            <div class="form-group">
                <label class="col-sm-4 control-label no-padding-right" for="id-date-picker-1"> Order Date</label>
                <div class="col-sm-8">
                    <div class="input-group"><span class="input-group-addon"> <i class="fa fa-calendar bigger-110"></i> </span>
                        <@spring.formInput  "POrder.orderDate" "class='date-picker form-control'  data-date-format='dd/mm/yyyy' readonly" />
                    </div>
                    <@spring.showErrors " & ", "err-msg" />
                </div>
            </div>


            <div class="form-group">
                <label class="col-sm-4 control-label no-padding-right" for="id-date-picker-1"> Scheduled Shipping
                    Date</label>
                <div class="col-sm-8">
                    <div class="input-group"><span class="input-group-addon"> <i class="fa fa-calendar bigger-110"></i> </span>
                        <@spring.formInput  "POrder.scheduledShippingDate" "class='date-picker form-control'  data-date-format='dd/mm/yyyy' readonly" />
                    </div>
                    <@spring.showErrors " & ", "err-msg" />
                </div>
            </div>


            <div class="form-group">
                <label class="col-sm-4 control-label no-padding-right" for="id-date-picker-1"> Record Date</label>
                <div class="col-sm-8">
                    <div class="input-group"><span class="input-group-addon"> <i class="fa fa-calendar bigger-110"></i> </span>
                        <@spring.formInput  "POrder.recordDate" "class='date-picker form-control'  data-date-format='dd/mm/yyyy' readonly" />
                    </div>
                    <@spring.showErrors " & ", "err-msg" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-4 control-label no-padding-right" for="user-name"> Operator Name </label>
                <div class="col-sm-8">
                    <span class="form-control">${userName!}</span>
                    <@spring.formHiddenInput  "POrder.operator.id" "class='form-control'" />
                    <@spring.showErrors " & ", "err-msg" />
                </div>
            </div>

        </div>
        <div class="col-xs-6">
            <div class="form-group">
                <label class="col-sm-4 control-label no-padding-right" for="user-name"> Operator Name </label>
                <div class="col-sm-8">
                    <span class="form-control">${userName!}</span>
                    <@spring.formHiddenInput  "POrder.operator.id" "class='form-control'" />
                    <@spring.showErrors " & ", "err-msg" />
                </div>
            </div>


        </div>
        <div class="col-lg-12">
            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9" style="text-align: right">
                    <button class="btn btn-white btn-bold btn-success" type="submit">
                        <i class="ace-icon glyphicon glyphicon-floppy-save bigger-110"></i>
                        Save
                    </button>
                    &nbsp; &nbsp; &nbsp;
                    <button class="btn btn-white btn-bold btn-danger btn-back" type="button" >
                        <i class="ace-icon fa fa-reply-all bigger-110"></i>
                        Back
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>

</@layout.taims_layout>

<style type="text/css">
    .control-label {
        font-weight: bold;
        color: #425d07;
    }

</style>
