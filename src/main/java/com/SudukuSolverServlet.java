package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GridInput")
public class SudukuSolverServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int[][] mat=new int[9][9];
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				String cellId="cell"+i+j;
				String cellValue=req.getParameter(cellId);
				if(cellValue==null) {
					mat[i][j]=0;
				}else if(cellValue.length()==0){
					mat[i][j]=0;
				}else {
					mat[i][j]=Math.abs(Integer.parseInt(cellValue));
				}
			}
		}
		
		if(solve(mat,0,0,9)) {
			System.out.println("solved");
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(mat[i][j]+" ");
				}
				System.out.println();
			}
		}else {
			System.out.println("cannot solve");
			resp.sendRedirect("IncorrectSuduku.jsp");
		}
		
		req.setAttribute("matrix", mat);
		RequestDispatcher rd=req.getRequestDispatcher("SudukuOutput.jsp");
		rd.forward(req, resp);
		
	}
	
	public boolean solve(int[][] mat,int i,int j,int n) {
		
		if(i==n) {
			return true;
		}
		
		if(j==n) {
			return solve(mat,i+1,0,n);
		}
		
		if(mat[i][j]!=0) {
			return solve(mat,i,j+1,n);
		}
		
		for(int x=1;x<=9;x++) {
			
			if(isSafe(mat,x,i,j,n)) {
				mat[i][j]=x;
				
				if(solve(mat,i,j+1,n)) {
					return true;
				}
				
				mat[i][j]=0;
				
			}
		}
		
		return false;
	}
	
	public boolean isSafe(int[][] mat,int x,int i,int j,int n) {
		
		for(int y=0;y<9;y++) {
			
			if(mat[y][j]==x || mat[i][y]==x) {
				return false;
			}
			
		}
		
		int rg=(i/3)*3;
		int cg=(j/3)*3;
		
		for(int a=rg;a<rg+3;a++) {
			for(int b=cg;b<cg+3;b++) {
				if(mat[a][b]==x) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
