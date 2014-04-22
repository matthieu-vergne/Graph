package fr.vergne.graph;

import java.util.Iterator;

/**
 * We speak here about a tree as considered in computer science (connected,
 * acyclic, directed graph with a single root), not a mathematical one
 * (connected acyclic graph).
 * 
 * @author Matthieu Vergne <matthieu.vergne@gmail.com>
 * 
 * @param <CNode>
 * @param <CLink>
 */
public interface Tree<CNode, CLink extends Arc<? extends CNode>> extends
		Graph<CNode, CLink> {

	public CNode getRoot();

	public ChildrenIterator<CNode> getChildrenOf(CNode vertex);

	public static interface ChildrenIterator<VertexType> extends
			Iterator<VertexType>, Iterable<VertexType> {

	}
}
