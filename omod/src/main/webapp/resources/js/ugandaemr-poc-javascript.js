    function enable_disable(field, class_name_prefix, conditions, input_type) {

        var class_name = jq(field).attr("class");

        var length = class_name.length;

        var class_id = parseInt(class_name.substring(length - 1, length));
        var childClass = "Child" + class_id;

        var disable = true;
        var requires = true;

        var row = '[class^="' + class_name_prefix + '"][class*="' + childClass + '"]';

        var selected_value = null;

        if (input_type == "select") {
            selected_value = jq(field).find(":selected").text().trim().toLowerCase();
        }
        else if (input_type == "hidden") {
            selected_value = jq(field).find("input[type=hidden]").val().trim().toLowerCase();
        }


        if (eval(conditions)) {
            disable = false;
        }


        jq(row).each(function () {
            var group = jq(this);

            if (class_name.indexOf('Child') == -1) {
                /*group.find("input").attr("value", ""); */
                /* group.find('select').prop("selectedIndex", 0);*/
                group.find("input").attr("disabled", disable);
                group.find('select').attr("disabled", disable);

                if (disable) {
                    /* fade out the fields that are disabled */
                    group.find("input").fadeTo(250, 0.25);
                    group.find("select").fadeTo(250, 0.25);
                } else {
                    /* remove the fade on the fields */
                    group.find("input").fadeTo(250, 1);
                    group.find("select").fadeTo(250, 1);
                }
            }
        });
    }

if (jQuery) {
    $(document).ready(function () {
        if ($.browser.msie) {
            $(":checkbox").click(function () {
                $(this).change();
            });
        }

        //Block Multiple encounter entry on same date
        blockEncounterOnSameDateEncounter(jq("#encounterDate").find("input[type=hidden]"),"block");

        jq('[class^="PreTestCounselingEnableDisable"]').change(function () {
            enable_disable(jq(this), "PreTestCounseling", 'selected_value == "yes"', "select");
        });

        jq('[class^="PreTestCounselingEnableDisable"]').each(function () {
            enable_disable(jq(this), "PreTestCounseling", 'selected_value == "yes"', "select");
        });

        jq('[class^="TestedBeforeEnableDisable"]').change(function () {
            enable_disable(jq(this), "TestedBefore", 'selected_value == "yes"', "select");
        });

        jq('[class^="TestedBeforeEnableDisable"]').each(function () {
            enable_disable(jq(this), "TestedBefore", 'selected_value == "yes"', "select");
        });

        jq('[class^="PartnerTestedBeforeEnableDisable"]').change(function () {
            enable_disable(jq(this), "PartnerTestedBefore", 'selected_value == "yes"', "select");
        });

        jq('[class^="PartnerTestedBeforeEnableDisable"]').each(function () {
            enable_disable(jq(this), "PartnerTestedBefore", 'selected_value == "yes"', "select");
        });

        jq('[class^="CounseledAsCoupleEnableDisable"]').change(function () {
            enable_disable(jq(this), "CounseledAsCouple", 'selected_value != "individual" &amp; selected_value != ""', "select");

            enable_disable(jq(".ResultAsCoupleEnableDisable1"), "ResultAsCouple", 'selected_value == "yes"', "select");
        });

        jq('[class^="CounseledAsCoupleEnableDisable"]').each(function () {
            enable_disable(jq(this), "CounseledAsCouple", 'selected_value != "individual" &amp; selected_value != ""', "select");
        });

        jq('[class^="ResultAsCoupleEnableDisable"]').change(function () {
            enable_disable(jq(this), "ResultAsCouple", 'selected_value == "yes"', "select");
        });

        jq('[class^="ResultAsCoupleEnableDisable"]').each(function () {
            enable_disable(jq(this), "ResultAsCouple", 'selected_value == "yes"', "select");
        });

        jq('[class^="LinkedToCareEnableDisable"]').change(function () {
            enable_disable(jq(this), "LinkedToCare", 'selected_value == "yes"', "select");
        });

        jq('[class^="LinkedToCareEnableDisable"]').each(function () {
            enable_disable(jq(this), "LinkedToCare", 'selected_value == "yes"', "select");
        });
    });
}

