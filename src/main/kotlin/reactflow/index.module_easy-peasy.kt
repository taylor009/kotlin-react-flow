@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION")

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*
import Store as ReduxStore

typealias KeysOfType<A, B> = Any

typealias IndexSignatureKeysOfType<A> = Any

external interface ActionCreator<Payload> {
    @nativeInvoke
    operator fun invoke(vararg args: Any): A
    @nativeInvoke
    operator fun invoke(payload: Payload)
    var type: String
    var z__creator: String /* 'actionWithPayload' */
}

external interface ThunkCreator<Payload, Result> {
    @nativeInvoke
    operator fun invoke(payload: Payload): Result
    var type: String
    var startType: String
    var successType: String
    var failType: String
    var z__creator: String /* 'thunkWithPayload' */
}

external fun <StateDraft : Any> debug(state: StateDraft): StateDraft

external fun <Fn : Function<*>> memo(fn: Fn, cacheSize: Number): Fn

typealias ListenerMapper<ActionsModel, Depth> = Any

typealias RecursiveListeners<Model, Depth> = Any

typealias Listeners<Model> = RecursiveListeners<Model, String /* '1' */>

typealias ActionMapper<ActionsModel, Depth> = Any

typealias RecursiveActions<Model, Depth> = Any

typealias Actions<Model> = RecursiveActions<Model, String /* '1' */>

typealias StateMapper<StateModel, Depth> = Any

typealias RecursiveState<Model, Depth> = Any

typealias State<Model> = RecursiveState<Model, String /* '1' */>

external fun <StoreModel : Any, InitialState : Any?, Injections> createStore(model: StoreModel, config: EasyPeasyConfig<InitialState, Injections> = definedExternally): LocalStore<StoreModel, EasyPeasyConfig<InitialState, Injections>>

external interface EasyPeasyConfig<InitialState : Any, Injections> {
    var compose: Any?
        get() = definedExternally
        set(value) = definedExternally
    var devTools: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var disableImmer: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var enhancers: Array<StoreEnhancer>?
        get() = definedExternally
        set(value) = definedExternally
    var initialState: InitialState?
        get() = definedExternally
        set(value) = definedExternally
    var injections: Injections?
        get() = definedExternally
        set(value) = definedExternally
    var middleware: Array<Middleware<Any, Any, Any>>?
        get() = definedExternally
        set(value) = definedExternally
    var mockActions: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
    var reducerEnhancer: ((reducer: Reducer<Any, Any>) -> Reducer<Any, Any>)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface MockedAction {
    var type: String
    @nativeGetter
    operator fun get(key: String): Any?
    @nativeSetter
    operator fun set(key: String, value: Any)
}

external interface LocalStore<StoreModel : Any?, StoreConfig : EasyPeasyConfig<Any, Any>> : ReduxStore<State<StoreModel>> {
    var addModel: (key: String, modelSlice: ModelSlice) -> Unit
    var clearMockedActions: () -> Unit
    var dispatch: Actions<StoreModel> /* Actions<StoreModel> & ReduxDispatch<Action> */
    var getActions: () -> Actions<StoreModel>
    var getListeners: () -> Listeners<StoreModel>
    var getMockedActions: () -> Array<MockedAction>
    var reconfigure: (model: NewStoreModel) -> Unit
    var removeModel: (key: String) -> Unit
}

typealias TargetResolver<Model, StoreModel> = (actions: Actions<Model>, storeActions: Actions<StoreModel>) -> dynamic

external interface TargetPayload<Payload> {
    var type: String
    var payload: Payload
    var result: Any?
        get() = definedExternally
        set(value) = definedExternally
    var error: Error?
        get() = definedExternally
        set(value) = definedExternally
    var resolvedTargets: Array<String>
}

typealias PayloadFromResolver<Resolver, Resolved> = Any

external interface Meta {
    var path: Array<String>
    var parent: Array<String>
}

external interface Thunk<Model : Any?, Payload, Injections, StoreModel : Any?, Result> {
    var type: String /* 'thunk' */
    var payload: Payload
    var result: Result
}

external interface `T$0`<Injections> {
    var dispatch: Actions<StoreModel> /* Actions<StoreModel> & ReduxDispatch<Action> */
    var getState: () -> State<Model>
    var getStoreActions: () -> Actions<StoreModel>
    var getStoreState: () -> State<StoreModel>
    var injections: Injections
    var meta: Meta
}

external fun <Model : Any?, Payload, Injections, StoreModel : Any?, Result> thunk(thunk: (actions: Actions<Model>, payload: Payload, helpers: `T$0`<Injections>) -> Result): Thunk<Model, Payload, Injections, StoreModel, Result>

external interface ThunkOn<Model : Any?, Injections, StoreModel : Any?> {
    var type: String /* 'thunkOn' */
}

external fun <Model : Any?, Injections, StoreModel : Any?, Resolver : TargetResolver<Model, StoreModel>> thunkOn(targetResolver: Resolver, handler: (actions: Actions<Model>, target: TargetPayload<PayloadFromResolver<Resolver>>, helpers: `T$0`<Injections>) -> Any): ThunkOn<Model, Injections, StoreModel>

external interface LocalAction<Model : Any?, Payload> {
    var type: String /* 'action' */
    var payload: Payload
    var result: dynamic /* Unit | State<Model> */
        get() = definedExternally
        set(value) = definedExternally
}

external fun <Model : Any?, Payload> action(action: (state: State<Model>, payload: Payload) -> dynamic): LocalAction<Model, Payload>

external interface ActionOn<Model : Any?, StoreModel : Any?> {
    var type: String /* 'actionOn' */
    var result: dynamic /* Unit | State<Model> */
        get() = definedExternally
        set(value) = definedExternally
}

external fun <Model : Any?, StoreModel : Any?, Resolver : TargetResolver<Model, StoreModel>> actionOn(targetResolver: Resolver, handler: (state: State<Model>, target: TargetPayload<PayloadFromResolver<Resolver>>) -> dynamic): ActionOn<Model, StoreModel>

external interface Computed<Model : Any?, Result, StoreModel : Any?> {
    var type: String /* 'computed' */
    var result: Result
}

typealias Resolver<Model, StoreModel> = (state: State<Model>, storeState: State<StoreModel>) -> Any

typealias DefaultComputationFunc<Model, Result> = (state: State<Model>) -> Result

external fun <Model : Any?, Result, StoreModel : Any?, Resolvers : Array<Resolver<Model, StoreModel>>> computed(resolversOrCompFunc: Resolvers, compFunc: (args: Any) -> Result = definedExternally): Computed<Model, Result, StoreModel>

external fun <Model : Any?, Result, StoreModel : Any?, Resolvers : Array<Resolver<Model, StoreModel>>> computed(resolversOrCompFunc: dynamic /* JsTuple<> */, compFunc: (args: Any) -> Result = definedExternally): Computed<Model, Result, StoreModel>

external fun <Model : Any?, Result, StoreModel : Any?, Resolvers : Array<Resolver<Model, StoreModel>>> computed(resolversOrCompFunc: DefaultComputationFunc<Model, Result>, compFunc: (args: Any) -> Result = definedExternally): Computed<Model, Result, StoreModel>

external interface LocalReducer<State, Action : Action> {
    var type: String /* 'reducer' */
    var result: State
}

external fun <State> reducer(state: Reducer<State>): LocalReducer<State, AnyAction>

external fun <StoreState : State<Any>, Result> useStoreState(mapState: (state: StoreState) -> Result, equalityFn: (prev: Result, next: Result) -> Boolean = definedExternally): Result

external fun <StoreActions : Actions<Any>, Result> useStoreActions(mapActions: (actions: StoreActions) -> Result): Result

external fun <StoreModel : Any?, StoreConfig : EasyPeasyConfig<Any, Any>> useStore(): LocalStore<StoreModel, StoreConfig>

external fun <StoreModel : Any?> useStoreDispatch(): Actions<StoreModel> /* Actions<StoreModel> & ReduxDispatch<Action> */

external interface `T$1` {
    var useStoreActions: (mapActions: (actions: Actions<StoreModel>) -> Result) -> Result
    var useStoreDispatch: () -> Actions<StoreModel>
    var useStoreState: (mapState: (state: State<StoreModel>) -> Result, equalityFn: (prev: Result, next: Result) -> Boolean) -> Result
    var useStore: () -> LocalStore<StoreModel, Any>
}

external fun <StoreModel : Any> createTypedHooks(): `T$1`

external open class StoreProvider<StoreModel : Any?> : Component<dynamic>

external interface StoreModelInitializer<StoreModel : Any?, InitialData> {
    @nativeInvoke
    operator fun invoke(initialData: InitialData = definedExternally): StoreModel
}

external interface `T$2`<InitialData> {
    var initialData: InitialData?
        get() = definedExternally
        set(value) = definedExternally
}

external interface `T$3` {
    var Provider: Any
    var useStore: () -> LocalStore<StoreModel, StoreConfig>
    var useStoreState: (mapState: (state: State<StoreModel>) -> Result, dependencies: Array<Any>) -> Result
    var useStoreActions: (mapActions: (actions: Actions<StoreModel>) -> Result) -> Result
    var useStoreDispatch: () -> Actions<StoreModel>
    var useStoreRehydrated: () -> Boolean
}

external fun <StoreModel : Any?, InitialData, StoreConfig : EasyPeasyConfig<Any, Any>> createContextStore(model: StoreModel, config: StoreConfig = definedExternally): `T$3`

external fun <StoreModel : Any?, InitialData, StoreConfig : EasyPeasyConfig<Any, Any>> createContextStore(model: StoreModelInitializer<StoreModel, InitialData>, config: StoreConfig = definedExternally): `T$3`

external interface UseLocalStore<StoreModel : Any?, InitialData> {
    @nativeInvoke
    operator fun invoke(initialData: InitialData = definedExternally): dynamic /* JsTuple<State<StoreModel>, Actions<StoreModel>> */
}

external fun <StoreModel : Any?, InitialData, StoreConfig : EasyPeasyConfig<Any, Any>> createComponentStore(model: StoreModel, config: StoreConfig = definedExternally): UseLocalStore<StoreModel, InitialData>

external fun <StoreModel : Any?, InitialData, StoreConfig : EasyPeasyConfig<Any, Any>> createComponentStore(model: StoreModelInitializer<StoreModel, InitialData>, config: StoreConfig = definedExternally): UseLocalStore<StoreModel, InitialData>

external interface PersistStorage {
    var getItem: (key: String) -> dynamic
    var setItem: (key: String, data: Any) -> dynamic
    var removeItem: (key: String) -> dynamic
}

external interface Transformer {
    var `in`: ((data: Any, key: String) -> Any)?
        get() = definedExternally
        set(value) = definedExternally
    var out: ((data: Any, key: String) -> Any)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface PersistConfig<Model : Any?> {
    var blacklist: Array<Any>?
        get() = definedExternally
        set(value) = definedExternally
    var mergeStrategy: String /* 'merge' | 'mergeDeep' | 'overwrite' */
    var storage: dynamic /* 'localStorage' | 'sessionStorage' | PersistStorage */
        get() = definedExternally
        set(value) = definedExternally
    var transformers: Array<Transformer>?
        get() = definedExternally
        set(value) = definedExternally
    var whitelist: Array<Any>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TransformConfig {
    var blacklist: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var whitelist: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
}

external fun createTransform(inbound: (data: Any, key: String) -> Any = definedExternally, outbound: (data: Any, key: String) -> Any = definedExternally, config: TransformConfig = definedExternally): Transformer

external fun <Model : Any?> persist(model: Model, config: PersistConfig<Model> = definedExternally): Model

external fun useStoreRehydrated(): Boolean