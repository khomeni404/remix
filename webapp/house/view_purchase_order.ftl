<#import "../taim_template/taims_layout.ftl" as layout>
<@layout.taims_layout  "${(title)!}" >
    <#import "/spring.ftl" as spring/>
    <#assign ctx = rc.getContextPath()/>

<div class="row">
    <div class="col-sm-6">
        <h5 class="header green lighter smaller">
            <i class="ace-icon fa fa-list smaller-60"></i>
            <b>Purchase Order</b>
        </h5>


    </div>
</div>

</@layout.taims_layout>
<script>
    //jquery accordion


</script>