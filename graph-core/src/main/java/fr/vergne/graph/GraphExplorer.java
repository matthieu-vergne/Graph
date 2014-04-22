package fr.vergne.graph;

import java.util.Iterator;

/**
 * A {@link GraphExplorer} provides a set of convenient methods to explore a
 * {@link Hypergraph} (so also a {@link Graph}).
 * 
 * @author Matthieu Vergne <matthieu.vergne@gmail.com>
 * 
 * @param <CVertex>
 * @param <CHyperedge>
 * @param <CHypergraph>
 */
public interface GraphExplorer<CVertex, CHyperedge extends Hyperedge<? extends CVertex>, CHypergraph extends Hypergraph<CVertex, CHyperedge>> {

	/**
	 * 
	 * @return the graph explored
	 */
	public CHypergraph getGraph();

	/**
	 * This method should return an {@link Iterator} which provides all the
	 * vertices present in the graph exactly once.
	 * 
	 * @return an {@link Iterator} over the vertices of the graph
	 */
	public Iterator<CVertex> verticesIterator();

	/**
	 * This method should return an {@link Iterator} which provides all the
	 * edges present in the graph exactly once.
	 * 
	 * @return an {@link Iterator} over the edges of the graph
	 */
	public Iterator<CHyperedge> edgesIterator();

	/**
	 * This method should return an {@link Iterator} which provides all the
	 * edges linking a given vertex exactly once.
	 * 
	 * @param vertex
	 *            the vertex to which recover the edges
	 * @return an {@link Iterator} over the edges on the vertex
	 */
	public Iterator<CHyperedge> edgesIterator(CVertex vertex);
}
