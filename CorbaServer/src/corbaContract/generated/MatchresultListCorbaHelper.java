package corbaContract.generated;


/**
* corbaContract/generated/MatchresultListCorbaHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from matchresult.idl
* Freitag, 16. November 2012 15:16 Uhr MEZ
*/

abstract public class MatchresultListCorbaHelper
{
  private static String  _id = "IDL:corbaContract/generated/MatchresultListCorba:1.0";

  public static void insert (org.omg.CORBA.Any a, corbaContract.generated.MatchresultListCorba that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static corbaContract.generated.MatchresultListCorba extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = corbaContract.generated.MatchresultCorbaHelper.type ();
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "matchresults",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (corbaContract.generated.MatchresultListCorbaHelper.id (), "MatchresultListCorba", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static corbaContract.generated.MatchresultListCorba read (org.omg.CORBA.portable.InputStream istream)
  {
    corbaContract.generated.MatchresultListCorba value = new corbaContract.generated.MatchresultListCorba ();
    int _len0 = istream.read_long ();
    value.matchresults = new corbaContract.generated.MatchresultCorba[_len0];
    for (int _o1 = 0;_o1 < value.matchresults.length; ++_o1)
      value.matchresults[_o1] = corbaContract.generated.MatchresultCorbaHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, corbaContract.generated.MatchresultListCorba value)
  {
    ostream.write_long (value.matchresults.length);
    for (int _i0 = 0;_i0 < value.matchresults.length; ++_i0)
      corbaContract.generated.MatchresultCorbaHelper.write (ostream, value.matchresults[_i0]);
  }

}