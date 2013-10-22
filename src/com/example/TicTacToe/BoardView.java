package com.example.TicTacToe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with IntelliJ IDEA.
 * User: yngvi
 * Date: 22.10.2013
 * Time: 17:42
 * To change this template use File | Settings | File Templates.
 */
public class BoardView extends View {

    char[][] m_board = new char[3][3];

    ShapeDrawable m_shape = new ShapeDrawable( new OvalShape() );
    Rect m_rect = new Rect();

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public void setBoard( String string )
    {
        for ( int idx=0, r=2; r>=0; --r ) {
            for ( int c=0; c<3; ++c, ++idx ) {
                m_board[c][r] = string.charAt( idx );
            }
        }
        invalidate();
    }

    /*
                        rect.set( col*diskWidth, row*diskHeight,
                              col*diskWidth+diskWidth, row*diskHeight+diskHeight);
                    m_disk.setBounds( rect );
                    switch ( m_boardStr.charAt(i) ) {
                        case 'x':
                            m_disk.getPaint().setColor( Color.RED );
                            m_disk.draw( canvas );

     */

    public void onDraw( Canvas canvas )
    {
        final int width = getWidth() / 3;
        final int height = getHeight() / 3;

        for ( int r=2; r>=0; --r ) {
            for ( int c=0; c<3; ++c ) {
                m_rect.set( c * width, r * height, c * width + width, r * height + height );
                m_shape.setBounds( m_rect );
                switch ( m_board[c][r] ) {
                    case 'x':
                        m_shape.getPaint().setColor( Color.RED );
                        m_shape.draw( canvas );
                        break;
                    case 'o':
                        m_shape.getPaint().setColor( Color.BLUE );
                        m_shape.draw( canvas );
                        break;
                    default:
                        m_shape.getPaint().setColor( Color.GREEN );
                        m_shape.draw( canvas );
                        break;
                }
            }
        }

    }
}
