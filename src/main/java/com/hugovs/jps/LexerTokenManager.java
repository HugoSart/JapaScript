/* LexerTokenManager.java */
/* Generated By:JavaCC: Do not edit this line. LexerTokenManager.java */
package com.hugovs.jps;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.io.*;
import com.hugovs.jps.structure.semanthic.*;
import com.hugovs.jps.structure.semanthic.command.*;
import com.hugovs.jps.structure.semanthic.operation.*;
import com.hugovs.jps.structure.semanthic.operation.bool.*;
import com.hugovs.jps.structure.semanthic.operation.compare.*;
import com.hugovs.jps.structure.semanthic.operation.integer.*;
import com.hugovs.jps.structure.semanthic.operation.string.*;
import com.hugovs.jps.structure.exception.*;

/** Token Manager. */
@SuppressWarnings("unused")public class LexerTokenManager implements LexerConstants {

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x9d180000L) != 0L)
         {
            jjmatchedKind = 32;
            return 47;
         }
         if ((active0 & 0x60000000L) != 0L)
         {
            jjmatchedKind = 32;
            return 26;
         }
         if ((active0 & 0x800000L) != 0L)
         {
            jjmatchedKind = 32;
            return 16;
         }
         if ((active0 & 0x8000L) != 0L)
            return 5;
         if ((active0 & 0x2000000L) != 0L)
         {
            jjmatchedKind = 32;
            return 34;
         }
         return -1;
      case 1:
         if ((active0 & 0xdf180000L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 1;
            return 47;
         }
         if ((active0 & 0x20000000L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 1;
            return 25;
         }
         if ((active0 & 0x800000L) != 0L)
            return 47;
         return -1;
      case 2:
         if ((active0 & 0xfd000000L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 2;
            return 47;
         }
         if ((active0 & 0x2180000L) != 0L)
            return 47;
         return -1;
      case 3:
         if ((active0 & 0x94000000L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 3;
            return 47;
         }
         if ((active0 & 0x69000000L) != 0L)
            return 47;
         return -1;
      case 4:
         if ((active0 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 4;
            return 47;
         }
         if ((active0 & 0x14000000L) != 0L)
            return 47;
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 10:
         return jjStopAtPos(0, 3);
      case 40:
         return jjStopAtPos(0, 6);
      case 41:
         return jjStopAtPos(0, 7);
      case 44:
         return jjStopAtPos(0, 12);
      case 58:
         return jjStopAtPos(0, 13);
      case 59:
         return jjStopAtPos(0, 14);
      case 61:
         return jjStartNfaWithStates_0(0, 15, 5);
      case 91:
         return jjStopAtPos(0, 10);
      case 93:
         return jjStopAtPos(0, 11);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x1000000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x2000000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x800000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x88000000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x60000000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x100000L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x14000000L);
      case 123:
         return jjStopAtPos(0, 8);
      case 125:
         return jjStopAtPos(0, 9);
      default :
         return jjMoveNfa_0(2, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x88080000L);
      case 102:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(1, 23, 47);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000L);
      case 107:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000000L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000000L);
      case 102:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(2, 19, 47);
         break;
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x54000000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000000L);
      case 114:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(2, 20, 47);
         else if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(2, 25, 47);
         break;
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 100:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(3, 27, 47);
         break;
      case 101:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(3, 24, 47);
         break;
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000L);
      case 112:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(3, 29, 47);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(3, 30, 47);
         break;
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(4, 26, 47);
         else if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(4, 28, 47);
         break;
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 110:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(5, 31, 47);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 47;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 47:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 32)
                        kind = 32;
                     { jjCheckNAddStates(0, 2); }
                  }
                  else if (curChar == 45)
                     { jjCheckNAdd(46); }
                  break;
               case 2:
                  if ((0xfffffffa00000000L & l) != 0L)
                  {
                     if (kind > 36)
                        kind = 36;
                  }
                  else if (curChar == 34)
                     { jjCheckNAddStates(3, 6); }
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 35)
                        kind = 35;
                     { jjCheckNAdd(42); }
                  }
                  else if ((0xac2000000000L & l) != 0L)
                  {
                     if (kind > 16)
                        kind = 16;
                  }
                  else if ((0x5000000000000000L & l) != 0L)
                  {
                     if (kind > 17)
                        kind = 17;
                  }
                  else if (curChar == 38)
                     jjstateSet[jjnewStateCnt++] = 11;
                  else if (curChar == 33)
                  {
                     if (kind > 18)
                        kind = 18;
                  }
                  else if (curChar == 61)
                     { jjCheckNAdd(5); }
                  if (curChar == 45)
                     { jjCheckNAdd(42); }
                  else if (curChar == 33)
                     { jjCheckNAdd(5); }
                  else if (curChar == 62)
                     { jjCheckNAdd(5); }
                  else if (curChar == 60)
                     { jjCheckNAdd(5); }
                  else if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 32)
                        kind = 32;
                     { jjCheckNAddStates(0, 2); }
                  }
                  else if (curChar == 45)
                     { jjCheckNAdd(46); }
                  break;
               case 26:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 32)
                        kind = 32;
                     { jjCheckNAddStates(0, 2); }
                  }
                  else if (curChar == 45)
                     { jjCheckNAdd(46); }
                  break;
               case 25:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 32)
                        kind = 32;
                     { jjCheckNAddStates(0, 2); }
                  }
                  else if (curChar == 45)
                     { jjCheckNAdd(46); }
                  break;
               case 34:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 32)
                        kind = 32;
                     { jjCheckNAddStates(0, 2); }
                  }
                  else if (curChar == 45)
                     { jjCheckNAdd(46); }
                  break;
               case 0:
                  if (curChar != 47)
                     break;
                  if (kind > 5)
                     kind = 5;
                  { jjCheckNAdd(1); }
                  break;
               case 1:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 5)
                     kind = 5;
                  { jjCheckNAdd(1); }
                  break;
               case 3:
                  if ((0xac2000000000L & l) != 0L && kind > 16)
                     kind = 16;
                  break;
               case 4:
                  if ((0x5000000000000000L & l) != 0L && kind > 17)
                     kind = 17;
                  break;
               case 5:
                  if (curChar == 61 && kind > 17)
                     kind = 17;
                  break;
               case 6:
                  if (curChar == 60)
                     { jjCheckNAdd(5); }
                  break;
               case 7:
                  if (curChar == 62)
                     { jjCheckNAdd(5); }
                  break;
               case 8:
                  if (curChar == 61)
                     { jjCheckNAdd(5); }
                  break;
               case 9:
                  if (curChar == 33)
                     { jjCheckNAdd(5); }
                  break;
               case 10:
                  if (curChar == 33 && kind > 18)
                     kind = 18;
                  break;
               case 11:
                  if (curChar == 38 && kind > 18)
                     kind = 18;
                  break;
               case 12:
                  if (curChar == 38)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 36:
                  if (curChar == 34)
                     { jjCheckNAddStates(3, 6); }
                  break;
               case 37:
                  if (curChar == 45)
                     { jjCheckNAdd(38); }
                  break;
               case 38:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddStates(3, 6); }
                  break;
               case 39:
                  if ((0xfffffffb00000000L & l) != 0L)
                     { jjCheckNAddStates(3, 6); }
                  break;
               case 40:
                  if (curChar == 34 && kind > 33)
                     kind = 33;
                  break;
               case 41:
                  if (curChar == 45)
                     { jjCheckNAdd(42); }
                  break;
               case 42:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 35)
                     kind = 35;
                  { jjCheckNAdd(42); }
                  break;
               case 43:
                  if ((0xfffffffa00000000L & l) != 0L && kind > 36)
                     kind = 36;
                  break;
               case 45:
                  if (curChar == 45)
                     { jjCheckNAdd(46); }
                  break;
               case 46:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 32)
                     kind = 32;
                  { jjCheckNAddStates(0, 2); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 47:
               case 44:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 32)
                     kind = 32;
                  { jjCheckNAddStates(0, 2); }
                  break;
               case 2:
                  if ((0x7fffffffffffffffL & l) != 0L)
                  {
                     if (kind > 36)
                        kind = 36;
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 32)
                        kind = 32;
                     { jjCheckNAddStates(0, 2); }
                  }
                  else if (curChar == 124)
                     jjstateSet[jjnewStateCnt++] = 13;
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 34;
                  else if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 30;
                  else if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 26;
                  else if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 20;
                  else if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 16;
                  break;
               case 16:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 32)
                        kind = 32;
                     { jjCheckNAddStates(0, 2); }
                  }
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 26:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 32)
                        kind = 32;
                     { jjCheckNAddStates(0, 2); }
                  }
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 25;
                  break;
               case 25:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 32)
                        kind = 32;
                     { jjCheckNAddStates(0, 2); }
                  }
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 34:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 32)
                        kind = 32;
                     { jjCheckNAddStates(0, 2); }
                  }
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 33;
                  break;
               case 1:
                  if (kind > 5)
                     kind = 5;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 13:
                  if (curChar == 124 && kind > 18)
                     kind = 18;
                  break;
               case 14:
                  if (curChar == 124)
                     jjstateSet[jjnewStateCnt++] = 13;
                  break;
               case 15:
                  if (curChar == 116 && kind > 21)
                     kind = 21;
                  break;
               case 17:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 16;
                  break;
               case 18:
                  if (curChar == 108 && kind > 21)
                     kind = 21;
                  break;
               case 19:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 18;
                  break;
               case 20:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 21:
                  if (curChar == 98)
                     jjstateSet[jjnewStateCnt++] = 20;
                  break;
               case 22:
                  if (curChar == 103 && kind > 21)
                     kind = 21;
                  break;
               case 23:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 24:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 23;
                  break;
               case 27:
                  if (curChar == 115)
                     jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 28:
                  if (curChar == 101 && kind > 22)
                     kind = 22;
                  break;
               case 29:
                  if (curChar == 117)
                     { jjCheckNAdd(28); }
                  break;
               case 30:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 29;
                  break;
               case 31:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 30;
                  break;
               case 32:
                  if (curChar == 115)
                     { jjCheckNAdd(28); }
                  break;
               case 33:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 32;
                  break;
               case 35:
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 34;
                  break;
               case 39:
                  if ((0x7fffffffffffffffL & l) != 0L)
                     { jjAddStates(3, 6); }
                  break;
               case 43:
                  if ((0x7fffffffffffffffL & l) != 0L && kind > 36)
                     kind = 36;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 5)
                     kind = 5;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               default : if (i1 == 0 || l1 == 0 || i2 == 0 ||  l2 == 0) break; else break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 47 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   45, 46, 44, 37, 38, 39, 40, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      default :
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, "\50", "\51", "\173", "\175", "\133", 
"\135", "\54", "\72", "\73", "\75", null, null, null, "\144\145\146", "\166\141\162", 
null, null, "\151\146", "\145\154\163\145", "\146\157\162", "\167\150\151\154\145", 
"\162\145\141\144", "\167\162\151\164\145", "\163\164\157\160", "\163\153\151\160", 
"\162\145\164\165\162\156", null, null, null, null, null, };
static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002200L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         SkipLexicalActions(null);
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 3 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                           Lexer.lineCount++;
         break;
      default :
         break;
   }
}
static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public LexerTokenManager(SimpleCharStream stream){

      if (input_stream != null)
        throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);

    input_stream = stream;
  }

  /** Constructor. */
  public LexerTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  static public void ReInit(SimpleCharStream stream)
  {
    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  static private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 47; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  static public void ReInit(SimpleCharStream stream, int lexState)
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  static public void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x1fffffffc1L, 
};
static final long[] jjtoSkip = {
   0x3eL, 
};
    static protected SimpleCharStream  input_stream;

    static private final int[] jjrounds = new int[47];
    static private final int[] jjstateSet = new int[2 * 47];

    private static final StringBuilder jjimage = new StringBuilder();
    private static StringBuilder image = jjimage;
    private static int jjimageLen;
    private static int lengthOfMatch;
    
    static protected char curChar;
}
