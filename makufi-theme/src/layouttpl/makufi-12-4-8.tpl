<div class="columns-12-4-8" id="main-content" role="main">
    <div class="portlet-layout row subSiteHeroContainer">
        <div class="col-md-12 portlet-column portlet-column-only" id="subSiteHeroContainer">
            $processor.processColumn("subSiteHeroContainer", 
            "portlet-column-content portlet-column-content-only")
        </div>
    </div>
    <div class="portlet-layout row main-main-content">
        <div class="col-md-12 portlet-column portlet-column-only" id="column-1">
            $processor.processColumn("column-1", 
            "portlet-column-content portlet-column-content-only")
        </div>
    </div>
    <div class="portlet-layout row main-main-content">
         <div class="col-md-4 portlet-column portlet-column-first" id="column-2">
                    $processor.processColumn("column-2", 
                    "portlet-column-content portlet-column-content-first")
         </div>
         <div class="col-md-8 portlet-column portlet-column-last" id="column-3">
                 $processor.processColumn("column-3", 
                 "portlet-column-content portlet-column-content-last")
         </div>
     </div>
</div>