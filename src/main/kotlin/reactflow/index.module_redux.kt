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

external interface Action<T> {
    var type: T
}

external interface AnyAction : Action<Any> {
    @nativeGetter
    operator fun get(extraProps: String): Any?
    @nativeSetter
    operator fun set(extraProps: String, value: Any)
}

external var `$CombinedState`: Any

typealias PreloadedState<S> = Any

typealias Reducer<S, A> = (state: S? /* = null */, action: A) -> S

typealias ReducersMapObject<S, A> = Any

typealias StateFromReducersMapObject<M> = Any

typealias ReducerFromReducersMapObject<M> = Any

typealias ActionFromReducer<R> = Any

typealias ActionFromReducersMapObject<M> = Any

external fun <S> combineReducers(reducers: ReducersMapObject<S, Any>): Reducer<Any /* Any & S */>

external fun <S, A : Action<Any>> combineReducers(reducers: ReducersMapObject<S, A>): Reducer<Any /* Any & S */, A>

external fun <M : ReducersMapObject<Any, Any>> combineReducers(reducers: M): Reducer<Any /* Any & StateFromReducersMapObject<M> */, ActionFromReducersMapObject<M>>

external interface Dispatch<A : Action<Any>> {
    @nativeInvoke
    operator fun <T : A> invoke(action: T): T
}

external interface Unsubscribe {
    @nativeInvoke
    operator fun invoke()
}

external interface `T$4` {
    var unsubscribe: Unsubscribe
}

external interface Observable<T> {
    var subscribe: (observer: Observer<T>) -> `T$4`
}

external interface Observer<T> {
    val next: ((value: T) -> Unit)?
        get() = definedExternally
}

external interface Store<S, A : Action<Any>> {
    var dispatch: Dispatch<A>
    fun getState(): S
    fun subscribe(listener: () -> Unit): Unsubscribe
    fun replaceReducer(nextReducer: Reducer<S, A>)
}

typealias DeepPartial<T> = Any

external interface StoreCreator {
    @nativeInvoke
    operator fun <S, A : Action<Any>, Ext, StateExt> invoke(reducer: Reducer<S, A>, enhancer: StoreEnhancer<Ext, StateExt> = definedExternally): Store<S /* S & StateExt */, A> /* Store<dynamic, A> & Ext */
    @nativeInvoke
    operator fun <S, A : Action<Any>, Ext, StateExt> invoke(reducer: Reducer<S, A>, preloadedState: PreloadedState<S> = definedExternally, enhancer: StoreEnhancer<Ext> = definedExternally): Store<S /* S & StateExt */, A> /* Store<dynamic, A> & Ext */
}

external var createStore: StoreCreator

typealias StoreEnhancer<Ext, StateExt> = (next: StoreEnhancerStoreCreator) -> StoreEnhancerStoreCreator<Ext, StateExt>

typealias StoreEnhancerStoreCreator<Ext, StateExt> = (reducer: Reducer<S, A>, preloadedState: PreloadedState<S>) -> Store<S /* S & StateExt */, A>

external interface MiddlewareAPI<D : Dispatch<AnyAction>, S> {
    var dispatch: D
    fun getState(): S
}

external interface Middleware<DispatchExt, S, D : Dispatch<AnyAction>> {
    @nativeInvoke
    operator fun invoke(api: MiddlewareAPI<D, S>): (next: Dispatch<AnyAction>) -> (action: Any) -> Any
}

external fun applyMiddleware(): StoreEnhancer

external interface `T$5`<Ext1> {
    var dispatch: Ext1
}

external fun <Ext1, S> applyMiddleware(middleware1: Middleware<Ext1, S, Any>): StoreEnhancer<`T$5`<Ext1>>

external interface `T$6` {
    var dispatch: Ext1 /* Ext1 & Ext2 */
}

external fun <Ext1, Ext2, S> applyMiddleware(middleware1: Middleware<Ext1, S, Any>, middleware2: Middleware<Ext2, S, Any>): StoreEnhancer<`T$6`>

external interface `T$7` {
    var dispatch: Ext1 /* Ext1 & Ext2 & Ext3 */
}

external fun <Ext1, Ext2, Ext3, S> applyMiddleware(middleware1: Middleware<Ext1, S, Any>, middleware2: Middleware<Ext2, S, Any>, middleware3: Middleware<Ext3, S, Any>): StoreEnhancer<`T$7`>

external interface `T$8` {
    var dispatch: Ext1 /* Ext1 & Ext2 & Ext3 & Ext4 */
}

external fun <Ext1, Ext2, Ext3, Ext4, S> applyMiddleware(middleware1: Middleware<Ext1, S, Any>, middleware2: Middleware<Ext2, S, Any>, middleware3: Middleware<Ext3, S, Any>, middleware4: Middleware<Ext4, S, Any>): StoreEnhancer<`T$8`>

external interface `T$9` {
    var dispatch: Ext1 /* Ext1 & Ext2 & Ext3 & Ext4 & Ext5 */
}

external fun <Ext1, Ext2, Ext3, Ext4, Ext5, S> applyMiddleware(middleware1: Middleware<Ext1, S, Any>, middleware2: Middleware<Ext2, S, Any>, middleware3: Middleware<Ext3, S, Any>, middleware4: Middleware<Ext4, S, Any>, middleware5: Middleware<Ext5, S, Any>): StoreEnhancer<`T$9`>

external interface `T$10`<Ext> {
    var dispatch: Ext
}

external fun <Ext, S> applyMiddleware(vararg middlewares: Middleware<Any, S, Any>): StoreEnhancer<`T$10`<Ext>>

external interface ActionCreatorsMapObject<A> {
    @nativeGetter
    operator fun get(key: String): ActionCreator<A>?
    @nativeSetter
    operator fun set(key: String, value: ActionCreator<A>)
}

external fun <A, C : ActionCreator<A>> bindActionCreators(actionCreator: C, dispatch: Dispatch<AnyAction>): C

external fun <A : ActionCreator<Any>, B : ActionCreator<Any>> bindActionCreators(actionCreator: A, dispatch: Dispatch<AnyAction>): B

external fun <A, M : ActionCreatorsMapObject<A>> bindActionCreators(actionCreators: M, dispatch: Dispatch<AnyAction>): M

external fun <M : ActionCreatorsMapObject<Any>, N : ActionCreatorsMapObject<Any>> bindActionCreators(actionCreators: M, dispatch: Dispatch<AnyAction>): N

typealias Func0<R> = () -> R

typealias Func1<T1, R> = (a1: T1) -> R

typealias Func2<T1, T2, R> = (a1: T1, a2: T2) -> R

typealias Func3<T1, T2, T3, R> = (a1: T1, a2: T2, a3: T3, args: Any) -> R

external fun compose(): (a: R) -> R

external fun <F : Function<*>> compose(f: F): F

external fun <A, R> compose(f1: (b: A) -> R, f2: Func0<A>): Func0<R>

external fun <A, T1, R> compose(f1: (b: A) -> R, f2: Func1<T1, A>): Func1<T1, R>

external fun <A, T1, T2, R> compose(f1: (b: A) -> R, f2: Func2<T1, T2, A>): Func2<T1, T2, R>

external fun <A, T1, T2, T3, R> compose(f1: (b: A) -> R, f2: Func3<T1, T2, T3, A>): Func3<T1, T2, T3, R>

external fun <A, B, R> compose(f1: (b: B) -> R, f2: (a: A) -> B, f3: Func0<A>): Func0<R>

external fun <A, B, T1, R> compose(f1: (b: B) -> R, f2: (a: A) -> B, f3: Func1<T1, A>): Func1<T1, R>

external fun <A, B, T1, T2, R> compose(f1: (b: B) -> R, f2: (a: A) -> B, f3: Func2<T1, T2, A>): Func2<T1, T2, R>

external fun <A, B, T1, T2, T3, R> compose(f1: (b: B) -> R, f2: (a: A) -> B, f3: Func3<T1, T2, T3, A>): Func3<T1, T2, T3, R>

external fun <A, B, C, R> compose(f1: (b: C) -> R, f2: (a: B) -> C, f3: (a: A) -> B, f4: Func0<A>): Func0<R>

external fun <A, B, C, T1, R> compose(f1: (b: C) -> R, f2: (a: B) -> C, f3: (a: A) -> B, f4: Func1<T1, A>): Func1<T1, R>

external fun <A, B, C, T1, T2, R> compose(f1: (b: C) -> R, f2: (a: B) -> C, f3: (a: A) -> B, f4: Func2<T1, T2, A>): Func2<T1, T2, R>

external fun <A, B, C, T1, T2, T3, R> compose(f1: (b: C) -> R, f2: (a: B) -> C, f3: (a: A) -> B, f4: Func3<T1, T2, T3, A>): Func3<T1, T2, T3, R>

external fun <R> compose(f1: (b: Any) -> R, vararg funcs: Function<*>): (args: Any) -> R

external fun <R> compose(vararg funcs: Function<*>): (args: Any) -> R

external fun <A, M : ActionCreatorsMapObject<A>> bindActionCreators(actionCreators: M, dispatch: Dispatch<AnyAction>): M