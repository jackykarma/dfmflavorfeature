/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.iqiyi.android.qigsaw.core.splitinstall.protocol;
// Declare any non-default types here with import statements

public interface ISplitInstallService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallService
{
private static final java.lang.String DESCRIPTOR = "com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallService interface,
 * generating a proxy if needed.
 */
public static com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallService))) {
return ((com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallService)iin);
}
return new com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
java.lang.String descriptor = DESCRIPTOR;
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(descriptor);
return true;
}
case TRANSACTION_startInstall:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<android.os.Bundle> _arg1;
_arg1 = data.createTypedArrayList(android.os.Bundle.CREATOR);
android.os.Bundle _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback _arg3;
_arg3 = com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback.Stub.asInterface(data.readStrongBinder());
this.startInstall(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_cancelInstall:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.os.Bundle _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback _arg3;
_arg3 = com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback.Stub.asInterface(data.readStrongBinder());
this.cancelInstall(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_getSessionState:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback _arg2;
_arg2 = com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback.Stub.asInterface(data.readStrongBinder());
this.getSessionState(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getSessionStates:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback _arg1;
_arg1 = com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback.Stub.asInterface(data.readStrongBinder());
this.getSessionStates(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_deferredInstall:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<android.os.Bundle> _arg1;
_arg1 = data.createTypedArrayList(android.os.Bundle.CREATOR);
android.os.Bundle _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback _arg3;
_arg3 = com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback.Stub.asInterface(data.readStrongBinder());
this.deferredInstall(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_deferredUninstall:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<android.os.Bundle> _arg1;
_arg1 = data.createTypedArrayList(android.os.Bundle.CREATOR);
android.os.Bundle _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback _arg3;
_arg3 = com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback.Stub.asInterface(data.readStrongBinder());
this.deferredUninstall(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void startInstall(java.lang.String packageName, java.util.List<android.os.Bundle> moduleNames, android.os.Bundle versionCode, com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeTypedList(moduleNames);
if ((versionCode!=null)) {
_data.writeInt(1);
versionCode.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_startInstall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void cancelInstall(java.lang.String packageName, int sessionId, android.os.Bundle versionCode, com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(sessionId);
if ((versionCode!=null)) {
_data.writeInt(1);
versionCode.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_cancelInstall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void getSessionState(java.lang.String packageName, int sessionId, com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(sessionId);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getSessionState, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void getSessionStates(java.lang.String packageName, com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getSessionStates, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void deferredInstall(java.lang.String packageName, java.util.List<android.os.Bundle> moduleNames, android.os.Bundle versionCode, com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeTypedList(moduleNames);
if ((versionCode!=null)) {
_data.writeInt(1);
versionCode.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_deferredInstall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void deferredUninstall(java.lang.String packageName, java.util.List<android.os.Bundle> moduleNames, android.os.Bundle versionCode, com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeTypedList(moduleNames);
if ((versionCode!=null)) {
_data.writeInt(1);
versionCode.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_deferredUninstall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_startInstall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_cancelInstall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getSessionState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getSessionStates = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_deferredInstall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_deferredUninstall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
}
public void startInstall(java.lang.String packageName, java.util.List<android.os.Bundle> moduleNames, android.os.Bundle versionCode, com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback callback) throws android.os.RemoteException;
public void cancelInstall(java.lang.String packageName, int sessionId, android.os.Bundle versionCode, com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback callback) throws android.os.RemoteException;
public void getSessionState(java.lang.String packageName, int sessionId, com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback callback) throws android.os.RemoteException;
public void getSessionStates(java.lang.String packageName, com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback callback) throws android.os.RemoteException;
public void deferredInstall(java.lang.String packageName, java.util.List<android.os.Bundle> moduleNames, android.os.Bundle versionCode, com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback callback) throws android.os.RemoteException;
public void deferredUninstall(java.lang.String packageName, java.util.List<android.os.Bundle> moduleNames, android.os.Bundle versionCode, com.iqiyi.android.qigsaw.core.splitinstall.protocol.ISplitInstallServiceCallback callback) throws android.os.RemoteException;
}
