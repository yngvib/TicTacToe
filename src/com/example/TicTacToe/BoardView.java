package com.example.TicTacToe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

    private char[][] m_board = new char[3][3];
    private Paint m_paint = new Paint();

    ShapeDrawable m_shape = new ShapeDrawable( new OvalShape() );
    Rect m_rect = new Rect();

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m_paint.setColor( Color.WHITE );
        m_paint.setStyle( Paint.Style.STROKE );
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

    public void onDraw( Canvas canvas )
    {
        final int width = getWidth() / 3;
        final int height = getHeight() / 3;

        for ( int r=2; r>=0; --r ) {
            for ( int c=0; c<3; ++c ) {
                m_rect.set( c * width, r * height, c * width + width, r * height + height );
                canvas.drawRect( m_rect, m_paint );
                m_rect.inset( (int)(m_rect.width() * 0.1), (int)(m_rect.height() * 0.1) );
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
                        break;
                }
            }
        }

    }
}
