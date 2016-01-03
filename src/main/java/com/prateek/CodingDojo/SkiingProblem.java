package com.prateek.CodingDojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class SkiingProblem {

	private int grid[][]; 
	private Map<Point, List<List<Integer>>> map = new HashMap<Point, List<List<Integer>>>();
	
	public List<List<Integer>> findMaximumPathOfSkii(final int grid[][], final Point point) {
		this.grid = grid;
		return findMaximumPath(point);
	}

	private List<List<Integer>> findMaximumPath(final Point point) {
		List<Point> adjacentPoints = findAdjacentPoints(point);
		List<List<Integer>> pathsWithMaxDistsnce = Lists.newArrayList();
		for (Point p : adjacentPoints) {
			if (!map.keySet().contains(p)) {
				for (List<Integer> list : findMaximumPath(p)) {
					
					if (!isSame(p, point)) {
					final List<Integer> l = Lists.newArrayList(list);
					l.add(grid[point.getX()][point.getY()]);
					final List<List<Integer>> li = Lists.newArrayList();
					li.add(l);
					pathsWithMaxDistsnce = li;
					checkIfPointAlreadyMapped(point, pathsWithMaxDistsnce); 
					}
				}
			} else {
				final List<List<Integer>> paths = map.get(p);
				final List<Integer> l = Lists.newArrayList(paths.get(0));
				l.add(grid[point.getX()][point.getY()]);
				final List<List<Integer>> li = Lists.newArrayList();
				li.add(l);
				pathsWithMaxDistsnce = li;
				checkIfPointAlreadyMapped(point, pathsWithMaxDistsnce);
			}
		}  
		
		if (adjacentPoints.isEmpty()) {
			List<Integer> path = Lists.newArrayList(grid[point.getX()][point.getY()]);
			final List<List<Integer>> list = Lists.newArrayList();
			list.add(path);
			pathsWithMaxDistsnce = list;
			map.put(point, pathsWithMaxDistsnce);
		}
		return map.get(point);
	}

	private boolean isSame(final Point p1, Point p2) {
		return grid[p1.getX()][p1.getY()] == grid[p2.getX()][p2.getY()] ? true : false;
	}

	private void checkIfPointAlreadyMapped(final Point point, final List<List<Integer>> pathsWithMaxDistsnce) {
		if (map.get(point) != null) {
			final List<List<Integer>> mappedPaths = map.get(point);
			final List<Integer> mappedPath1 = mappedPaths.get(0);
			final List<Integer> mappedPath2 = pathsWithMaxDistsnce.get(0);
			if (mappedPath1.size() < mappedPath2.size()) {
				map.put(point, pathsWithMaxDistsnce);
			} else if (mappedPath1.size() == mappedPath2.size()) {
				 mappedPaths.add(mappedPath2);
			}
			
		} else {
			map.put(point, pathsWithMaxDistsnce);
		}
	}

	private List<Point> findAdjacentPoints(Point point) {
		List<Point> adjacentPoints = Lists.newArrayList();
		return  prepareAdjacentPoints(adjacentPoints, point);
	}

	private List<Point> prepareAdjacentPoints(final List<Point> adjacentPoints, final Point point) {
		int x = point.getX();
		int y = point.getY();
		
		if (x == 0) {
			Point p1 = new Point(x + 1, y);
			adjacentPoints.add(p1);
			prepare(x, y, adjacentPoints);
			
		} else if(x == grid.length - 1) {
			Point p1 = new Point(x - 1, y);
			adjacentPoints.add(p1);
			prepare(x, y, adjacentPoints);
		} else {
			final Point p1 = new Point(x - 1, y);
			final Point p2 = new Point(x + 1, y);
			
            if (y > 0 && y != grid.length - 1) {
            final Point p3 = new Point(x, y + 1);
            final Point p4 = new Point(x, y - 1);
            adjacentPoints.add(p3);
            adjacentPoints.add(p4);
			} else if (y == 0) {
			final Point p3 = new Point(x, y + 1);
			adjacentPoints.add(p3);
			} else if (y == grid.length - 1) {
			final Point p4 = new Point(x, y - 1);
			adjacentPoints.add(p4);
			}
			adjacentPoints.add(p1);
			adjacentPoints.add(p2);
		}
		return Lists.newArrayList(Iterables.filter(adjacentPoints, new Predicate<Point>() {
			public boolean apply(final Point input) {
				return grid[input.getX()][input.getY()] <= grid[point.getX()][point.getY()] ? true : false;
			}
		}));
	}

	private void prepare(int x, int y, List<Point> adjacentPoints) {
		if (y == 0) {
			Point p1 = new Point(x, y + 1);
		adjacentPoints.add(p1);	
		} else if (y == grid.length - 1) {
			Point p1 = new Point(x, y - 1);
			adjacentPoints.add(p1);
		} else {
			Point p2 = new Point(x, y - 1);
			Point p3 = new Point(x, y + 1);
			adjacentPoints.add(p2);
			adjacentPoints.add(p3);
		}
	}
}
