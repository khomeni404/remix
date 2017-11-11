<#import "../taim_template/taims_layout.ftl" as layout>
<@layout.taims_layout  "${(title)!}" >
    <#import "/spring.ftl" as spring/>
    <#assign ctx = rc.getContextPath()/>
    <#assign command = SampleMaster/>

<div class="row">
    <form id="incident-form" action="${ctx}/house/saveSample.ibbl" method="POST" class="form-horizontal"
          role="form">

        <div class="col-xs-6">
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="refNo"> Sample No </label>

                <div class="col-sm-9">
                    <@spring.formInput  "SampleMaster.modelNo" "class='col-sm-2 se-num'" />
                    <@spring.showErrors " & ", "err-msg" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="incident-type"> Sample Name</label>

                <div class="col-sm-9">
                    <@spring.formInput  "SampleMaster.modelName" "class='form-control'" />
                    <@spring.showErrors " & ", "err-msg" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="user-name"> Operator Name </label>
                <div class="col-sm-9">
                    <span class="form-control">${userName!}</span>
                    <@spring.formHiddenInput  "SampleMaster.operator.id" "class='form-control'" />
                    <@spring.showErrors " & ", "err-msg" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="id-date-picker-1"> Record Date</label>

                <div class="col-sm-9">
                    <div class="input-group"><span class="input-group-addon"> <i class="fa fa-calendar bigger-110"></i> </span>
                        <@spring.formInput  "SampleMaster.recordDate" "class='date-picker  col-sm-4'  data-date-format='dd/mm/yyyy' readonly" />
                    </div>
                    <@spring.showErrors " & ", "err-msg" />

                </div>
            </div>

        </div>

        <div class="col-xs-6">
            <div class="form-group">
                <label class="col-sm-4 control-label no-padding-right" for="incident-type"> Supplier</label>
                <div class="col-sm-8">
                    <@spring.formSingleSelect "SampleMaster.supplier.id", supplierMap!,  "class='form-control select2-single' data-placeholder='Choose a Sample...'"/>
                        <@spring.showErrors " & ", "err-msg" />
                </div>
            </div>
        </div>

        <div class="col-xs-12">
            <div class="col-lg-12">
                <div class="clearfix form-actions">
                    <div class="col-md-offset-3 col-md-9" style="text-align: right">
                        <button class="btn btn-white btn-bold btn-success" type="submit">
                            <i class="ace-icon glyphicon glyphicon-floppy-save bigger-110"></i>
                            Update
                        </button>
                        &nbsp; &nbsp; &nbsp;
                        <button class="btn btn-white btn-bold btn-danger btn-back" type="button" >
                            <i class="ace-icon fa fa-reply-all bigger-110"></i>
                            Back
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </form>
</div>

</@layout.taims_layout>