AUI.add(
	'liferay-cloud-services',
	function(A) {
		var Lang = A.Lang;

		var CSS_LCS_CLUSTER_ENTRY_DIALOG = 'lcs-cluster-entry-dialog';

		var EVENT_CHANGE = 'change';

		var EVENT_CLICK = 'click';

		var EVENT_INPUT = 'input';

		var EVENT_SUBMIT = 'submit';

		var EVENT_VISIBLE_CHANGE = 'visibleChange';

		var SELECTOR_LCS_CLUSTER_ENTRY_ADD_FORM = 'fm';

		var STR_EMPTY = '';

		var STR_SUCCESS = 'success';

		var STR_URI = 'uri';

		var STR_VALUE = 'value';

		var TPL_FIELD_HIDDEN = '<input class="field-input field-input-text" id="{portletNamespace}lcsClusterEntryId" name="{portletNamespace}lcsClusterEntryId" type="hidden" value="" />';

		var TPL_FIELD_OPTION = '<option value="{0}">{1}</option>';

		var TPL_FIELD_SELECT = '<div class="control-group">' +
			'<select class="aui-field-select" id="{portletNamespace}lcsClusterEntryId" name="{portletNamespace}lcsClusterEntryId">' +
				'{optionalContent}' +
			'</select>' +
		'</div>';

		var TYPE_ADD_LCS_CLUSTER_ENTRY = 0;

		var TYPE_SERVE_CORP_ENTRY = 1;

		var TYPE_SERVE_LCS_CLUSTER_ENTRY = 2;

		var LCS = A.Component.create(
			{
				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'liferay-cloud-services',

				prototype: {
					initializer: function(config) {
						var instance = this;

						var urlMap = {};

						urlMap[TYPE_ADD_LCS_CLUSTER_ENTRY] = config.addLCSClusterEntryURL;
						urlMap[TYPE_SERVE_CORP_ENTRY] = config.serveCorpEntryURL;
						urlMap[TYPE_SERVE_LCS_CLUSTER_ENTRY] = config.serveLCSClusterEntryURL;

						instance._urlMap = urlMap;

						instance._lcsClusterEntryIdNode = instance.byId('lcsClusterEntryId');
						instance._lcsClusterEntryInputWrapper = instance.byId('lcsClusterEntryInputWrapper');
						instance._registrationForm = instance.byId('registrationFm');

						instance._portletContentBox = instance._registrationForm.ancestor('.portlet-content');

						instance.byId('addEnvironmentButton').on(EVENT_CLICK, instance._createLCSClusterEntryPanel, instance);
						instance.byId('corpEntryId').on(EVENT_CHANGE, instance._loadData, instance);
						instance.byId('name').on(EVENT_INPUT, A.bind('_refreshSubmitDisabled', instance));
					},

					_initializeLCSClusterEntryPanel: function() {
						var instance = this;

						var lcsClusterEntryFormAdd = instance.byId(SELECTOR_LCS_CLUSTER_ENTRY_ADD_FORM, instance._lcsClusterEntryPanel);

						var name = instance.one('#name', lcsClusterEntryFormAdd);

						lcsClusterEntryFormAdd.detach(EVENT_SUBMIT);

						name.on(EVENT_INPUT, A.bind('_onLCSClusterEntryNameInput', instance));

						lcsClusterEntryFormAdd.on(EVENT_SUBMIT, instance._onLCSClusterEntryFormSubmit, instance, lcsClusterEntryFormAdd);

						instance._lcsClusterEntryFormAdd = lcsClusterEntryFormAdd;
					},

					_loadData: function(event) {
						var instance = this;

						A.io.request(
							instance._createURL(TYPE_SERVE_CORP_ENTRY),
							{
								dataType: 'json',
								form: {
									id: instance._registrationForm.getDOM()
								},
								on: {
									success: function(event, id, obj) {
										var data = this.get('responseData');

										instance._refreshFormData(data);
									}
								}
							}
						);
					},

					_createHiddenNode: function(value) {
						var instance = this;

						var auiHiddenNode = instance._nodeFromTemplate(TPL_FIELD_HIDDEN);

						auiHiddenNode.val(value);

						return auiHiddenNode;
					},

					_createSelectNode: function(optionsArray) {
						var instance = this;

						var options = A.Array.map(
							optionsArray,
							function(item, index, collection) {
								return Lang.sub(TPL_FIELD_OPTION, [item.lcsClusterEntryId, item.name]);
							}
						);

						options = options.join('');

						var templateNode = instance._nodeFromTemplate(TPL_FIELD_SELECT, options);

						var selectNode = templateNode.one('select');

						selectNode.set('selectedIndex', optionsArray.length - 1);

						return templateNode;
					},

					_createLCSClusterEntryPanel: function() {
						var instance = this;

						var lcsClusterEntryPanel = instance._lcsClusterEntryPanel;

						var lcsClusterEntryPanelRenderURL = instance._createURL(TYPE_ADD_LCS_CLUSTER_ENTRY);

						if (!lcsClusterEntryPanel) {
							lcsClusterEntryPanel = Liferay.Util.Window.getWindow(
								{
									dialog: {
										centered: true,
										cssClass: CSS_LCS_CLUSTER_ENTRY_DIALOG,
										height: 560,
										modal: true,
										resizable: false,
										width: 600
									},
									title: Liferay.Language.get('new-environment')
								}
							).render(instance._portletContentBox);

							lcsClusterEntryPanel.plug(
								A.Plugin.IO,
								{
									autoLoad: false,
									uri: lcsClusterEntryPanelRenderURL
								}
							);

							lcsClusterEntryPanel.on(
								EVENT_VISIBLE_CHANGE,
								function(event) {
									if (!event.newVal && instance._lcsClusterEntryFormAdd) {
										instance._lcsClusterEntryFormAdd.reset();
									}
								}
							);

							instance._lcsClusterEntryPanel = lcsClusterEntryPanel;
						}
						else if (instance._currentLCSClusterEntryPanelAddIOHandle) {
							instance._currentLCSClusterEntryPanelAddIOHandle.detach();

							lcsClusterEntryPanel.io.set(STR_URI, lcsClusterEntryPanelRenderURL);
						}

						lcsClusterEntryPanel.show();

						lcsClusterEntryPanel._syncUIPosAlign();

						instance._currentLCSClusterEntryPanelAddIOHandle = lcsClusterEntryPanel.io.after(
							STR_SUCCESS,
							A.bind('_initializeLCSClusterEntryPanel', instance)
						);

						lcsClusterEntryPanel.io.start();
					},

					_createURL: function(type) {
						var instance = this;

						var url = instance._urlMap[type] || '';

						if (url && type != TYPE_SERVE_LCS_CLUSTER_ENTRY) {
							var selectedCorpEntryId = instance.one('#corpEntryId', instance._registrationForm).val();

							url = Liferay.Util.addParams(instance.ns('corpEntryId') + '=' + selectedCorpEntryId, url);
						}

						return url;
					},

					_nodeFromTemplate: function(tpl, parameter) {
						var instance = this;

						if (!parameter) {
							parameter = STR_EMPTY;
						}

						var tplHTML = Lang.sub(
							tpl,
							{
								portletNamespace: instance.NS,
								optionalContent: parameter
							}
						);

						return A.Node.create(tplHTML);
					},

					_onLCSClusterEntryFormSubmit: function(event, form) {
						var instance = this;

						event.halt();

						A.io.request(
							instance._createURL(TYPE_SERVE_LCS_CLUSTER_ENTRY),
							{
								dataType: 'json',
								form: {
									id: form.getDOM()
								},
								on: {
									success: function(event, id, obj) {
										var responseData = this.get('responseData');

										if (responseData.result == 'success') {
											instance._lcsClusterEntryPanel.hide();

											instance._loadData();
										}
									}
								}
							}
						);
					},

					_onLCSClusterEntryNameInput: function(event) {
						var instance = this;

						var disabled = !(Lang.trim(event.currentTarget.val()));

						Liferay.Util.toggleDisabled(instance.byId('create'), disabled);
					},

					_refreshFormData: function(data) {
						var instance = this;

						var corpEntrySelect = instance.byId('corpEntryId', instance._registrationForm);

						var corpEntries = data.corpEntries;

						if (corpEntries && !corpEntrySelect.get('children').size()) {
							var options = A.Array.map(
								corpEntries,
								function(item, index, collection) {
									return Lang.sub(TPL_FIELD_OPTION, [item.corpEntryId, item.name]);
								}
							);

							corpEntrySelect.append(options.join(''));
						}

						var lcsClusterEntries = data.lcsClusterEntries;

						var lcsClusterEntryIdNode = instance._lcsClusterEntryIdNode;
						var lcsClusterEntryInputWrapper = instance._lcsClusterEntryInputWrapper;

						if (lcsClusterEntryIdNode) {
							lcsClusterEntryInputWrapper.empty();
						}

						if (lcsClusterEntries.length > 0) {
							lcsClusterEntryIdNode = instance._createSelectNode(lcsClusterEntries);

							lcsClusterEntryInputWrapper.append(lcsClusterEntryIdNode);

							instance._lcsClusterEntryIdNode = lcsClusterEntryIdNode;
						}
						else {
							instance._lcsClusterEntryIdNode = null;
						}

						instance._refreshSubmitDisabled();
					},

					_refreshSubmitDisabled: function(event) {
						var instance = this;

						var registrationForm = instance._registrationForm;

						var disabled = !instance._lcsClusterEntryIdNode || !instance.one('#name', registrationForm).val();

						Liferay.Util.toggleDisabled(instance.one('#register', registrationForm), disabled);
					}
				}
			}
		);

		Liferay.Portlet.LCS = LCS;
	},
	'',
	{
		requires: ['liferay-util-window', 'aui-io-plugin-deprecated', 'dd', 'liferay-portlet-base', 'liferay-portlet-url', 'resize']
	}
);