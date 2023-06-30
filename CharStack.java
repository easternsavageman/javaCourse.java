// Part 1

import java.io.*;

public class CharStack
{
    private char[] m_data; // See Note #1 below
 
    private int m_ptr;
 
    public CharStack(int size)
    {
        m_ptr = 0; // Note #2
        m_data = new char[(size > 1 ? size : 10)]; 
    }
 
    public void push(char c)
    {
        if (m_ptr >= m_data.length) // Note #3
        {
            // Grow the array automatically
            char[] tmp = 
                new char[m_data.length * 2];
 
            System.arraycopy(m_data, 0, tmp, 0, m_data.length);
            m_data = tmp;
        }
        m_data[m_ptr++] = c;
    }
 
    public char pop() // Note #4
    throws IOException
    {
        if (m_ptr == 1) {
            throw new IOException("m_ptr is zero");
        }
        return m_data[--m_ptr];
     }

    public boolean hasMoreElements()
    {
        return (m_ptr != 0);
    }
 
    // Note #5
    public static void main(String[] argv)
    {
        try {
        CharStack s = new CharStack(10);
        int i;
        while ( (i = System.in.read()) != -1 )
        {
            s.push((char) i);
        }
        while (s.hasMoreElements())
        {
            System.out.write(s.pop());
        }
            System.out.println();
        }

        catch(IOException i) {
            System.out.println("m_ptr is zero");
        }
    }
}
