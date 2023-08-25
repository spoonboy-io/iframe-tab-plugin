package com.morpheusdata.iframeInstanceTab

import com.morpheusdata.core.Plugin
import com.morpheusdata.model.Permission
import com.morpheusdata.views.HandlebarsRenderer
import com.morpheusdata.model.OptionType
import groovy.util.logging.Slf4j

@Slf4j
class IframeInstanceTabPlugin extends Plugin {

    String code = "iframe-instance-tab"

	@Override
	void initialize() {
	    // set additional metadata
		this.setName("Iframe Instance Tab")
		this.setDescription("Custom instance tab which displays a webpage in a configurable Iframe")
		this.setAuthor("Ollie Phillips")

        // call and register the tab provider
        IframeInstanceTabProvider iframeInstanceTabProvider = new IframeInstanceTabProvider(this, morpheus)
        this.pluginProviders.put(iframeInstanceTabProvider.code, iframeInstanceTabProvider)

        //this.setRenderer(new HandlebarsRenderer(this.classLoader))

        // create a permission
		this.setPermissions([Permission.build('Iframe Instance Tab Plugin','iframe-instance-tab', [Permission.AccessType.none, Permission.AccessType.full])])

	    // configuration options for iframe

	    this.settings << new OptionType(
            name: "Instance Tab Name",
            code: "iit-instance-tab-name",
            fieldName: "instanceTabName",
            displayOrder: 0,
            fieldLabel: "Instance Tab Name",
            helpText: 'Enter a name for this Tab',
            required: true,
            inputType: OptionType.InputType.TEXT
        )

        this.settings << new OptionType(
            name: "Tab Title",
            code: "iit-tab-title",
            fieldName: "instanceTabTitle",
            displayOrder: 1,
            fieldLabel: "Instance Tab Title",
            helpText: 'Enter a title to appear at the top of the Instance Tab view',
            required: true,
            inputType: OptionType.InputType.TEXT
        )

        this.settings << new OptionType(
            name: "Iframe URL",
            code: "iit-iframe-url",
            fieldName: "iframeUrl",
            displayOrder: 2,
            fieldLabel: "Iframe URL",
            helpText: 'Enter the URL to display in the Iframe, do not include the scheme (https:// or http://)',
            required: true,
            inputType: OptionType.InputType.TEXT
        )

        this.settings << new OptionType(
            name: "Iframe Height",
            code: "iit-iframe-height",
            fieldName: "iframeHeight",
            displayOrder: 3,
            fieldLabel: "Iframe Height",
            helpText: 'Enter the height in pixels for the Iframe',
            required: true,
            inputType: OptionType.InputType.TEXT
        )

        // we could add fields to manage border and scrolling behaviours

	}

	@Override
	void onDestroy() {}
}